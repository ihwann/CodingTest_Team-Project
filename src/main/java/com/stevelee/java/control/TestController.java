
package com.stevelee.java.control;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.java.dao.TestDao;
import com.stevelee.java.dto.GetTestDto;
import com.stevelee.java.dto.TestDto;

@Controller
public class TestController {

	@Autowired
	private SqlSession sqlSession;

	HttpSession session;

	// 문제유형 선택 후 문제풀기 첫 화면
	@RequestMapping(value = "/testcoding", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {

		TestDao testDao = sqlSession.getMapper(TestDao.class);

		// 로그인되어 있는 아이디 , 내가 선택한 문제 타입세팅
		TestDto dto = new TestDto();
		dto.setTest_result_no(149);
		dto.setTest_result_user("steavelee");
		dto.setCate("samsung");

		// 선택한 문제유형에서 내가풀어야 할 단계의 문제정보를 획득
		Map<String, String> map = new HashMap<String, String>();
		List<GetTestDto> list = testDao.select_test(dto);
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i).getSent_type(), list.get(i).getSent_cont());
		}

		// 과거이력정보 획득
		dto.setTest_result_no(list.get(0).getTest_no());
		List<TestDto> list2 = testDao.get_test_his(dto);

		// 선택한 문제유형의 전체 문제 리스트 획득
		List<Integer> testList = new ArrayList<Integer>();
		testList = testDao.select_test_list(dto.getCate());

		map.put("cate", dto.getCate());
		model.addAttribute("map", map);
		model.addAttribute("history", list2);
		model.addAttribute("testList", testList);

		return "test/testcoding.tiles";
	}

	// 문제제출
	@ResponseBody
	@RequestMapping(value = "/insertTest", method = RequestMethod.POST)
	public Map<String, Object> insertProblem(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = new TestDto();
		Map<String, Object> map = new HashMap<String, Object>();

		// 로그인 완성되면 세션에서 아이디 가져오는 로직 작성
		String id = "steavelee";

		// 사용자가 입력한 입력값 받아오기
		String body = (String) request.getParameter("code");
		int timer = Integer.parseInt((String) request.getParameter("timer"));
		int codeLength = Integer.parseInt((String) request.getParameter("codeLength"));
		int test_no = 142;
		System.out.println(test_no);

		// 프로젝트 Home Directory 경로 조회
		// String path =
		// TestController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String path = "C:\\steveleegit\\190620\\steveleejavacoding\\src\\main\\java";

		// Java File 생성

		File sourceFile = new File(path + "/com/stevelee/java/dynamic/DynamicClass.java");

		// input, output값 가져오기
		List<GetTestDto> setInput = dao.setInput(test_no);
		GetTestDto setOutput = dao.setOutput(test_no);
		String input = setInput.get(0).getSent_cont();
		String output = setOutput.getSent_cont();

		FileWriter fw2 = new FileWriter(path + "/com/stevelee/java/dynamic/test.txt");
		fw2.write(input);
		fw2.close();

		DataInputStream dis = new DataInputStream(new FileInputStream(path + "/com/stevelee/java/dynamic/test.txt"));

		String line = "";
		while (true) {
			line = dis.readLine();
			if (line == null)
				break;
			System.out.println("line : " + line);
		}
		/*
		 * System.out.println("input : " + input); String[] lines = input.split("\n");
		 * for(int a = 0; a < lines.length; a++) { System.out.println("input [" + a +
		 * "] : " + input); }
		 */

		// 기본소스코드 양식과 입력받은 소스를 합쳐 완성된 소스 생성
		StringBuffer sb = new StringBuffer();
		sb.append("public class DynamicClass {");
		sb.append("public String[] runMethod() throws Exception {");
		sb.append("System.gc();");
		sb.append("long start = System.currentTimeMillis();");
		sb.append("long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
		// sb.append("String input =\"" + input + "\";");
		sb.append("String output = null;");

		sb.append("long end = System.currentTimeMillis();");
		sb.append("long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
		sb.append("long time = end - start;");
		sb.append("long usedMemory = (before - after)/1024/1024;");
		sb.append("String Stringtime = Long.toString(time);");
		sb.append("String usedMemory2 = Long.toString(usedMemory);");
		sb.append("String[] result = {output, Stringtime, usedMemory2};");
		// sb.append("long[] result = {time, usedMemory};");
		sb.append("return result;");
		sb.append(" }");
		// sb.append(body);
		sb.append("} ");
		String source = sb.toString();

		// Java File에 소스입력
		FileWriter fw = new FileWriter(sourceFile);
		fw.write(source);
		fw.flush();
		fw.close();

		// Java 컴파일(class파일 생성)
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, System.out, System.out, sourceFile.getPath());

		if (result == 0) {
			System.out.println("컴파일 성공");
		} else {
			System.out.println("컴파일 에러");
		}

		// 생성된 Class를 Load
		URLClassLoader classLoader = URLClassLoader
				.newInstance(new URL[] { new File(path + "/com/stevelee/java/dynamic").toURI().toURL() });
		Class<?> cls = Class.forName("DynamicClass", true, classLoader);

		// Load한 Class의 객체생성
		Object obj = cls.newInstance();

		// Class내부에 선언된 함수를 실행
		String methodName = "runMethod";
		Method objMethod = obj.getClass().getMethod(methodName);
		String[] methodResult = (String[]) objMethod.invoke(obj);

		// 결과 확인
		System.out.println(methodResult[0]);
		System.out.println(Integer.parseInt(methodResult[1]));
		System.out.println(Integer.parseInt(methodResult[2]));

		// 결과값 dto세팅
		dto.setTest_result_no(32);
		dto.setTest_result_user(id);
		dto.setTest_result_code(body);
		dto.setTest_result("pass");
		dto.setTest_result_time(timer);
		dto.setTest_result_useMemory(300);
		dto.setTest_result_runingTime(20);
		dto.setTest_result_count(1);
		dto.setTest_result_error(0);
		dto.setTest_result_codeLength(codeLength);

		// 세팅된 dto를 db에 입력
		TestDao testDao = sqlSession.getMapper(TestDao.class);
		testDao.insert_result(dto);

		// 프론트에 전달할 결과값이 담긴 Map생성
		map.put("code", body);
		map.put("result", "통과");
		map.put("time", timer);
		map.put("memory", 37);
		map.put("runningtime", 20);
		map.put("resultcount", 1);
		map.put("error", 0);
		map.put("codeLength", codeLength);

		System.out.println("time: " + methodResult[0]);
		System.out.println("memory: " + methodResult[1]);

		return map;
	}

	// 문제제출
	@ResponseBody
	@RequestMapping(value = "/insertTest147", method = RequestMethod.POST)
	public Map<String, Object> insertTest147(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = new TestDto();
		Map<String, Object> map = new HashMap<String, Object>();

		// 로그인 완성되면 세션에서 아이디 가져오는 로직 작성

		session = request.getSession();
		Object objid = session.getAttribute("email");

		System.out.println("objid : " + objid);
		String email = "";
		if (objid != null)
			email = (String) objid;

		String id = email;

		// 사용자가 입력한 입력값 받아오기
		String body = (String) request.getParameter("code");
		int timer = Integer.parseInt((String) request.getParameter("timer"));
		int codeLength = Integer.parseInt((String) request.getParameter("codeLength"));
		int test_no = 149;
		System.out.println(test_no);
		System.out.println("body" + body);

		// 프로젝트 Home Directory 경로 조회
		// String path =
		// TestController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String path = "C:\\steveleegit\\190620\\steveleejavacoding\\src\\main\\java";
		// Java File 생성

		File sourceFile = new File(path + "/com/stevelee/java/dynamic/DynamicClass.java");

		// input, output값 가져오기
		List<GetTestDto> setInput = dao.setInput(test_no);
		GetTestDto setOutput = dao.setOutput(test_no);

		int inputsize = setInput.size();

		String input1 = "";
		String input2 = "";
		FileWriter fw2 = new FileWriter(path + "/com/stevelee/java/dynamic/test.txt");

		if (inputsize == 1) {
			input1 = setInput.get(0).getSent_cont();
			fw2.write(input1);
		} else {
			input1 = setInput.get(0).getSent_cont();
			input2 = setInput.get(1).getSent_cont();
			fw2.write(input1);
			fw2.write("\n");
			fw2.write(input2);
		}

		String output = setOutput.getSent_cont();

		fw2.close();

		DataInputStream dis = new DataInputStream(new FileInputStream(path + "/com/stevelee/java/dynamic/test.txt"));

		String line = "";
		while (true) {
			line = dis.readLine();
			if (line == null)
				break;
			System.out.println("line : " + line);
		}
		/*
		 * System.out.println("input : " + input); String[] lines = input.split("\n");
		 * for(int a = 0; a < lines.length; a++) { System.out.println("input [" + a +
		 * "] : " + input); }
		 */

		// 기본소스코드 양식과 입력받은 소스를 합쳐 완성된 소스 생성
		StringBuffer sb = new StringBuffer();
		sb.append("import java.util.Arrays;");
		sb.append("public class DynamicClass {");
		sb.append("public String[] runMethod() throws Exception {");
		sb.append("System.gc();");
		sb.append("long start = System.currentTimeMillis();");
		sb.append("long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
		// sb.append("String input =\"" + input + "\";");
		sb.append("String output = null;String rtn =\"\";");

		//

		if (inputsize == 1) {
			sb.append("solution(" + input1 + ");");
		} else {
			sb.append("String[] in1 =" + input1 + ";");
			sb.append("String[] in2 =" + input2 + ";");
			sb.append("String returnrnt = solution(in1,in2);");
		}
		sb.append("if(returnrnt.equals(\"" + output + "\")) {System.out.println(\"success\");rtn=\"삼쏭에 합격하셨습니다\";}");
		sb.append("else {System.out.println(\"fail\");rtn=\"다시한번 풀어보세요\";}");
		sb.append("long end = System.currentTimeMillis();");
		sb.append("long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
		sb.append("long time = end - start;");
		sb.append("long usedMemory = (before - after)/1024/1024;");
		sb.append("String Stringtime = Long.toString(time);");
		sb.append("String usedMemory2 = Long.toString(usedMemory);");
		sb.append("String[] result = {output, Stringtime, usedMemory2, rtn};");
		// sb.append("long[] result = {time, usedMemory};");
		sb.append("return result;");
		sb.append(" }");
		sb.append(body);
		sb.append("} ");
		String source = sb.toString();

		// Java File에 소스입력
		FileWriter fw = new FileWriter(sourceFile);
		fw.write(source);
		fw.flush();
		fw.close();

		// Java 컴파일(class파일 생성)
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, System.out, System.out, sourceFile.getPath());

		if (result == 0) {
			System.out.println("컴파일 성공");
		} else {
			System.out.println("컴파일 에러");
		}

		// 생성된 Class를 Load
		URLClassLoader classLoader = URLClassLoader
				.newInstance(new URL[] { new File(path + "/com/stevelee/java/dynamic").toURI().toURL() });
		Class<?> cls = Class.forName("DynamicClass", true, classLoader);

		// Load한 Class의 객체생성
		Object obj = cls.newInstance();

		// Class내부에 선언된 함수를 실행
		String methodName = "runMethod";
		Method objMethod = obj.getClass().getMethod(methodName);
		String[] methodResult = (String[]) objMethod.invoke(obj);

		// 결과 확인
		System.out.println(methodResult[0]);
		System.out.println(Integer.parseInt(methodResult[1]));
		System.out.println(Integer.parseInt(methodResult[2]));
		System.out.println(methodResult[3]);

		// 결과값 dto세팅
		dto.setTest_result_no(32);
		dto.setTest_result_user(id);
		dto.setTest_result_code(body);
		dto.setTest_result("pass");
		dto.setTest_result_time(timer);
		dto.setTest_result_useMemory(300);
		dto.setTest_result_runingTime(20);
		dto.setTest_result_count(1);
		dto.setTest_result_error(0);
		dto.setTest_result_codeLength(codeLength);

		// 세팅된 dto를 db에 입력
		TestDao testDao = sqlSession.getMapper(TestDao.class);
		testDao.insert_result(dto);

		// 프론트에 전달할 결과값이 담긴 Map생성
		map.put("code", body);
		map.put("result", "통과");
		map.put("time", timer);
		map.put("memory", 37);
		map.put("runningtime", 20);
		map.put("resultcount", 1);
		map.put("error", 0);
		map.put("codeLength", codeLength);
		map.put("rtn", methodResult[3]);

		System.out.println("time: " + methodResult[0]);
		System.out.println("memory: " + methodResult[1]);

		return map;
	}

	// 문제제출
	@ResponseBody
	@RequestMapping(value = "/insertTest150", method = RequestMethod.POST)
	public Map<String, Object> insertTest150(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = new TestDto();
		Map<String, Object> map = new HashMap<String, Object>();

		// 로그인 완성되면 세션에서 아이디 가져오는 로직 작성

		session = request.getSession();
		Object objid = session.getAttribute("email");

		System.out.println("objid : " + objid);
		String email = "";
		if (objid != null)
			email = (String) objid;

		String id = email;

		// 사용자가 입력한 입력값 받아오기
		String body = (String) request.getParameter("code");
		int timer = Integer.parseInt((String) request.getParameter("timer"));
		int codeLength = Integer.parseInt((String) request.getParameter("codeLength"));
		int test_no = 150;
		System.out.println(test_no);
		System.out.println("body" + body);

		// 프로젝트 Home Directory 경로 조회
		// String path =
		// TestController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String path = "C:\\steveleegit\\190620\\steveleejavacoding\\src\\main\\java";
		// Java File 생성

		File sourceFile = new File(path + "/com/stevelee/java/dynamic/DynamicClass2.java");

		// input, output값 가져오기
		List<GetTestDto> setInput = dao.setInput(test_no);
		GetTestDto setOutput = dao.setOutput(test_no);

		int inputsize = setInput.size();

		String input1 = "";
		String input2 = "";
		FileWriter fw2 = new FileWriter(path + "/com/stevelee/java/dynamic/test.txt");

		if (inputsize == 1) {
			input1 = setInput.get(0).getSent_cont();
			fw2.write(input1);
		} else {
			input1 = setInput.get(0).getSent_cont();
			input2 = setInput.get(1).getSent_cont();
			fw2.write(input1);
			fw2.write("\n");
			fw2.write(input2);
		}

		String output = setOutput.getSent_cont();

		return map;
	}

	// 문제 임시저장
	@ResponseBody
	@RequestMapping(value = "/saveCoding", method = RequestMethod.GET)
	public String saveTest(Locale locale, Model model, HttpServletRequest request) {

		TestDto dto = new TestDto();

		// 입력값 받아오기
		String id = "stevelee";
		String body = (String) request.getParameter("code");
		int timer = Integer.parseInt((String) request.getParameter("timer"));
		int codeLength = Integer.parseInt((String) request.getParameter("codeLength"));

		// 임시저장 값 dto세팅
		dto.setTest_result_no(32);
		dto.setTest_result_user(id);
		dto.setTest_result_code(body);
		dto.setTest_result("save");
		dto.setTest_result_count(11);
		dto.setTest_result_codeLength(codeLength);

		return "test/testcoding.tiles";
	}

	// 과거이력 상세조회
	@ResponseBody
	@RequestMapping(value = "/gethistory", method = RequestMethod.POST)
	public TestDto getHistory(Locale locale, Model model, HttpServletRequest request) {

		String num = (String) request.getParameter("num");

		TestDto dto = new TestDto();
		int seq = Integer.parseInt(num);
		TestDao testDao = sqlSession.getMapper(TestDao.class);
		dto = testDao.select_his(seq);

		return dto;
	}
}

package com.stevelee.java.control;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevelee.java.dao.TestDao;
import com.stevelee.java.dto.TestDto;

@Controller
public class TestController {
	
	
    @Autowired
    private SqlSession sqlSession;
	
    
    
    // 문제작성화면 호출
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//TestDao dao = sqlSession.getMapper(TestDao.class);
		
		//int no = 1;
		//model.addAttribute(dao.select_test(no));
		System.out.println("d");
		
		return "test/testcoding.tiles";
	}
	
	
	
	
	
	// 문제리스트 -> 문제작성화면 이동
	@RequestMapping(value = "/pratice111", method = RequestMethod.GET)
	public String testWrite(Locale locale, Model model) {
		
		return "test/testcoding.tiles";
	}
	
	// 텍스트에디터
	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public String editor(Locale locale, Model model) {
		
		return "test/editor.tiles";
	}
	// 문제작성 완료 후 문제 제출 -> 결과 보여주기
	@RequestMapping(value = "/try1", method = RequestMethod.GET)
	public String try1(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = new TestDto();
		
		// 로그인 완성되면 세션에서 아이디 가져오는 로직 작성
		String id = "steavelee";
		
		// 입력한 소스코드 받아오기
		String body = "System.out.println(44);";
		System.out.println(body);
 
        // 프로젝트 Home Directory 경로 조회
        String path = TestController.class.getProtectionDomain().getCodeSource().getLocation().getPath();   
        System.out.println("path:" + path);
        
     // Class File 생성
        File sourceFile = new File(path + "DynamicClass.java");

        // 기본소스코드 양식과 입력받은 소스를 합쳐 완성된 소스 생성
        StringBuffer sb = new StringBuffer();
        	sb.append("public class DynamicClass {");
        	sb.append("public static void main(String[] args) {");
        	sb.append("System.gc();");
        	sb.append("long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
        	sb.append("long start = System.currentTimeMillis();");
        	sb.append(body);
        	sb.append("long end = System.currentTimeMillis();");
        	sb.append("long time = end - start;");
        	sb.append("long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
        	sb.append("long usedMemory = (before - after)/1024/1024;");
            sb.append("} }");
        String source = sb.toString();
        
		// Class File에 소스입력
		FileWriter fw = new FileWriter(sourceFile);
		fw.write(source);
		fw.flush();
		fw.close();
		
		System.out.println("sourceFile.getPath() :" + sourceFile.getPath());
        // Class File 컴파일
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, System.out, System.out, sourceFile.getPath());
        //int result = compiler.run(null, System.out, System.out, "DynamicClass.java");
        
	        if(result == 0) {
	        	System.out.println("컴파일 성공");
	        }else {
	        	System.out.println("컴파일 에러");
	        }
        
        // 컴파일된 Class를 Load
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {new File(path + "DynamicClass").toURI().toURL()});
        System.out.println("경로 : " + new File(path + "DynamicClass").toURI().toURL());
        System.out.println("classLoader : " + classLoader);
        Class<?> cls = Class.forName("DynamicClass", true, classLoader);
        System.out.println("Load 성공");
        
        return "home.tiles";
	}
	
	
	
	
	// 문제작성 완료 후 문제 제출 -> 결과 보여주기
	@RequestMapping(value = "/insertProblem", method = RequestMethod.POST)
	public String insertProblem(Locale locale, Model model, HttpServletRequest request) throws Exception {
		
		TestDao dao = sqlSession.getMapper(TestDao.class);
		TestDto dto = new TestDto();
		
		// 로그인 완성되면 세션에서 아이디 가져오는 로직 작성
		String id = "steavelee";
		
		// 입력한 소스코드 받아오기
		String body = (String)request.getParameter("code");
		System.out.println(body);
 
        // 프로젝트 Home Directory 경로 조회
        String path = TestController.class.getProtectionDomain().getCodeSource().getLocation().getPath();    
        
        // Class File 생성
        File sourceFile = new File(path + "DynamicClass.java");

        // 기본소스코드 양식과 입력받은 소스를 합쳐 완성된 소스 생성
        StringBuffer sb = new StringBuffer();
        	sb.append("public class DynamicClass {");
        	sb.append("public String runMethod() throws Exception {");
        	sb.append("System.gc();");
        	sb.append("long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
        	sb.append("long start = System.currentTimeMillis();");
        	sb.append(body);
        	sb.append("long end = System.currentTimeMillis();");
        	sb.append("long time = end - start;");
        	sb.append("long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();");
        	sb.append("long usedMemory = (before - after)/1024/1024;");
        	sb.append("return \"하이염\";");
            sb.append("} }");
        String source = sb.toString();
        
		// Class File에 소스입력
		FileWriter fw = new FileWriter(sourceFile);
		fw.write(source);
		fw.flush();
		fw.close();
		
        // Class File 컴파일
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, System.out, System.out, sourceFile.getPath());
        
	        if(result == 0) {
	        	System.out.println("컴파일 성공");
	        }else {
	        	System.out.println("컴파일 에러");
	        }
        
        // 컴파일된 Class를 Load
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {new File(path + "DynamicClass").toURI().toURL()});
        System.out.println("경로 : " + new File(path + "DynamicClass").toURI().toURL());
        System.out.println("classLoader : " + classLoader);
        Class<?> cls = Class.forName("DynamicClass", true, classLoader);
        System.out.println("Load 성공");
        
        // Load한 Class의 객체생성
        Object obj = cls.newInstance();
        
        // 컴파일된 Class파일의 함수를 선택하여 실행
        String methodName = "runMethod";
        Method objMethod = obj.getClass().getMethod(methodName);
        String methodResult = (String)objMethod.invoke(obj);
 
        // 실행 결과 출력
        System.out.print("result : " + methodResult);

        
        dto.setResult_no(11);
        dto.setResult_user(id);
        dto.setReslult_code("code");
        dto.setResult("통과");
        dto.setResult_time(60);
        dto.setResult_userMemory(300);
        dto.setRuning_time(20);
        dto.setReslut_count(11);
        dto.setResult_error(1);
        
        //dao.insert_result(dto);
		//model.addAttribute(dto);

		return "PraticeMain.tiles";
	}
}




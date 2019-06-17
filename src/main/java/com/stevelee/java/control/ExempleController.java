package com.stevelee.java.control;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.java.dao.TestMakeDao;
import com.stevelee.java.dto.TestmakeCateDto;
import com.stevelee.java.dto.TestmakeContentsDto;
import com.stevelee.java.dto.TestmakeSenttype;


/**
 * Handles requests for the application home page.
 */
@Controller
public class ExempleController {
	
	HttpSession session;
	
	
	@Autowired
	private SqlSession sqlSession;
	

	//ajax 사용 예제 1
	//String 화면으로 보내기
    @RequestMapping(value="test1Ajax")
    @ResponseBody
    public String test1Ajax (  HttpSession session, Model model
    		, Map<String, Object> modelMap
    		, HttpServletRequest request
    		, HttpServletResponse response
    		) throws Exception {
    	
    	String result = "";
    	
    	int test_no = Integer.parseInt(request.getParameter("test_no"));
    	
    	System.out.println("test1Ajax");
    	
    	TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
    	ArrayList<TestmakeContentsDto> senttype = testdao.selectlist_testmake_contents(test_no);
    	
    	for(TestmakeContentsDto item : senttype) {
    		System.out.println("item contents : " + item.getSent_cont());
    		result += item.getSent_cont();
    	}
    	
		/*
		 * response.setCharacterEncoding("utf-8");
		 * response.setContentType("charset=UTF-8");
		 */
    	
    	return result;
    }
    	
	 
	//ajax 사용 예제 2
	//JSONArray 화면으로 보내기
    @RequestMapping(value="test2Ajax")
    public void test2Ajax (  HttpSession session, Model model
    		, @RequestBody String jsonList
    		, HttpServletRequest request
    		, HttpServletResponse response
    		) throws Exception {
    	
    	System.out.println("test2Ajax");
    	System.out.println("jsonList:" + jsonList);
    	
    	JSONParser json = new JSONParser();
    	JSONArray obj = (JSONArray)json.parse(jsonList);
    	
    	for(int num = 0; num < obj.size(); num++) {

    		
    		JSONObject obj2 = (JSONObject)json.parse(obj.get(num).toString());
    		System.out.println("contents:" + obj2.get("contents"));
    		
    	}
    	
    	TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
    	ArrayList<TestmakeSenttype> senttype = testdao.selectlist_testmake_senttype();
    	
    	
    	JSONArray jarry = new JSONArray();
    	
    	for(int i = 0; i < senttype.size(); i++) {
    		JSONObject jobj = new JSONObject();
    		jobj.put("sent_type", senttype.get(i).getSent_type());
    		jobj.put("sent_type_name", senttype.get(i).getSent_type_name());
    		jarry.add(jobj);
    	}
    	
    
    	System.out.println("jarry:" + jarry.toString());
    	
    	response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();		

		out.print(jarry.toString());
		
		out.flush();
		out.close();
		

    }
    
	 //콤보박스 사용예제
	 @RequestMapping(value = "/exemplejsp", method = RequestMethod.GET)
	 public String testcate(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		 

		TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
		ArrayList<String> testcatelist = testdao.selectlist_testmake_cate();
		ArrayList<TestmakeCateDto> testcatelist2 = testdao.selectlist_testmake_cate2();
	  
		System.out.println(testcatelist.get(0));
		System.out.println(testcatelist2.get(0).getTest_cate() + testcatelist2.get(0).getTest_cate_name());
		
		model.addAttribute("testcatelist", testcatelist);
		model.addAttribute("testcatelist2", testcatelist2);
		
		ArrayList<TestmakeCateDto> testtype = testdao.selectlist_testmake_type();
		model.addAttribute("testtype", testtype);
		ArrayList<TestmakeCateDto> testtypebasic = testdao.selectlist_testmake_type_param(testcatelist2.get(0).getTest_cate());
		model.addAttribute("testtypebasic", testtypebasic);
		ArrayList<TestmakeCateDto> testtypess = testdao.selectlist_testmake_type_param(testcatelist2.get(1).getTest_cate());
		model.addAttribute("testtypess", testtypess);
		ArrayList<TestmakeSenttype> senttype = testdao.selectlist_testmake_senttype();
		model.addAttribute("senttype", senttype);

		 
		//testdao.insert_testmake_cate(new TestmakeCateDto("t2", "t2", "한글1", "한글1"));

	  return "test/exemplejsp.tiles";  //

	 }


	 
	 
	 // 로그인 세션 사용예제
	 // 아래 주석도 포함하여 참고하시면 됩니다
	@RequestMapping(value = "/exemplelogin", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String url = "phoneStore/login/login";
		
		
		
		session = request.getSession();
		
		System.out.println("sessionid :" + session.getId());
		/*
		StoreDto sdto = (StoreDto)session.getAttribute("sdto");
		
		if(sdto != null) {
			System.out.println("insertPhone jsp");
			url = "phoneStore/phoneregi/insertPhone";
		}else {
			
			System.out.println("login jsp");
			model.addAttribute("loginrst", 0);
		}
		*/
		
		return url;
	}	



	//ajax string or int return exemple
	@RequestMapping(value = "/examajax")
	@ResponseBody
	public int exam8ajax(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String id = request.getParameter("id");
		
		System.out.println("id : " + id );
		
		int regichk = 0;
		
		if("steve".equals(id) ) {
			regichk = 1;
		}
		return regichk;
		
	}
	
	
}

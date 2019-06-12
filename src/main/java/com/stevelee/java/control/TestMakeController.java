package com.stevelee.java.control;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevelee.java.dao.TestMakeDao;
import com.stevelee.java.dto.TestmakeCateDto;
import com.stevelee.java.dto.TestmakeSenttype;


/**
 * Handles requests for the application home page.
 */
@Controller
public class TestMakeController {
	
	HttpSession session;
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	 @RequestMapping(value = "/test1", method = RequestMethod.GET)
	 public String test1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 

	  return "test1.tiles";  //

	 }
	 
	 @RequestMapping(value = "/testmake", method = RequestMethod.GET)
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

	  return "test/testmake.tiles";  //

	 }


	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	 public String index(Model model) {
	  
	  return "index.tiles";  //
	 }
	

	 
	 
	 /*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String url = "phoneStore/login/login";
		
		
		
		session = request.getSession();
		
		System.out.println("sessionid :" + session.getId());
		
		StoreDto sdto = (StoreDto)session.getAttribute("sdto");
		
		if(sdto != null) {
			System.out.println("insertPhone jsp");
			url = "phoneStore/phoneregi/insertPhone";
		}else {
			
			System.out.println("login jsp");
			model.addAttribute("loginrst", 0);
		}
		
		
		return url;
	}	



	
	@RequestMapping(value = "/exam8ajax")
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
	*/
	
}

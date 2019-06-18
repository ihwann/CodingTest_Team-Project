package com.stevelee.java.control;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.java.dao.TestListDao;
import com.stevelee.java.dto.TestviewListDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestListController {
	
	HttpSession session;
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	 @RequestMapping(value="testListAjax")
	    @ResponseBody
	    // java 객체를 http 요정의 body 내용으로 매핑하는 역할을 합니다.
	    public String testListAjax (  HttpSession session, Model model
	    		, Map<String, Object> modelMap
	    		, HttpServletRequest request
	    		, HttpServletResponse response
	    		) throws Exception {
	
		 
		 
		
		  String result = "";
		  
		  int test_no = Integer.parseInt(request.getParameter("test_no"));
		  
		  System.out.println("testlistAjax");
		  
		 /* TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
		  ArrayList<TestviewListDto> senttype =
		  testdao.selectlist_testmake_contents(test_no);
		  
		  for(TestmakeContentsDto item : senttype) {
		  System.out.println("item contents : " + item.getSent_cont()); result +=
		  item.getSent_cont(); }
		 */
			/*
			 * response.setCharacterEncoding("utf-8");
			 * response.setContentType("charset=UTF-8");
			 */
	    	
	    	return result ;
	    }
	
	
	 @RequestMapping(value = "/testlist", method = RequestMethod.GET)
	 public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		
		/*
		 * TestListDao testlistdao = sqlSession.getMapper(TestListDao.class);
		 * ArrayList<TestviewListDto> testlistview = testlistdao.select_testListAll();
		 * System.out.println(testlistview);
		 */

	  return "test/testlist.tiles";  //

	 }
	
}

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestListController {
	
	HttpSession session;
	
	
	@Autowired
	private SqlSession sqlSession;
	
	 @RequestMapping(value = "/testlist", method = RequestMethod.GET)
	 public String main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 



	  return "test/testlist.tiles";  //

	 }
	
}

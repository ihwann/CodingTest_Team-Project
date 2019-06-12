package com.stevelee.java.control;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import com.stevelee.java.dao.TestMakeDao;
//import com.stevelee.java.dto.TestmakeCateDto;

@Controller
public class CommunityController {

	HttpSession session;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/commu/review", method = RequestMethod.GET)
	public String listReview(Locale locale, Model model) {
		
		
		return "commu/review.tiles";
	}
	
	@RequestMapping(value = "/commu/jobs", method = RequestMethod.GET)
	public String listJobs(Locale locale, Model model) {
		
		
		return "commu/jobs.tiles";
	}
	
	@RequestMapping(value = "/commu/uploadReview", method = RequestMethod.GET)
	public String uploadReview(Locale locale, Model model) {
		
		
		return "commu/uploadAndModifyReview.tiles";
	}
	
	@RequestMapping(value = "/commu/uploadJobs", method = RequestMethod.GET)
	public String uploadJobs(Locale locale, Model model) {
		
		
		return "commu/uploadAndModifyJob.tiles";
	}
	
	@RequestMapping(value = "/commu/modifyReview", method = RequestMethod.GET)
	public String modifyReview(Locale locale, Model model) {
		
		
		return "commu/uploadAndModifyReview.tiles";
	}
	
	@RequestMapping(value = "/commu/modifyJobs", method = RequestMethod.GET)
	public String modifyJobs(Locale locale, Model model) {
		
		
		return "commu/uploadAndModifyJob.tiles";
	}
}

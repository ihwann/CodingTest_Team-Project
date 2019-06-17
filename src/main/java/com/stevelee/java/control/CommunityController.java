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

import com.stevelee.java.dao.JobDao;
import com.stevelee.java.dao.ReviewDao;
import com.stevelee.java.dao.TestDao;
import com.stevelee.java.dto.JobDto;
import com.stevelee.java.dto.ReviewDto;
import com.stevelee.java.dto.TestDto;

//import com.stevelee.java.dao.TestMakeDao;
//import com.stevelee.java.dto.TestmakeCateDto;

@Controller
public class CommunityController {

	HttpSession session;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//review list 화면 호출 
	@RequestMapping(value = "/commu/review", method = RequestMethod.GET)
	public String listReview(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<ReviewDto> reviewList = dao.select_all_review();
	
		//ArrayList<String> compList = dao.select_all_review_comp();
		for(int i = 0; i < reviewList.size();i++) {
			reviewList.get(i).getReview_date();
		}
		
//		for(int i = 0; i < compList.size();i++) {
//			System.out.println(compList.get(i));
//		}
//		//model.addAttribute("compList", compList);
//		model.addAttribute("reviewList", reviewList);

		
		return "commu/review.tiles";
	}
	
	
	
	@RequestMapping(value = "/commu/jobs", method = RequestMethod.GET)
	public String listJobs(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		JobDao dao = sqlSession.getMapper(JobDao.class);
		ArrayList<JobDto> jobList = dao.select_all_job();
		
		for(int i = 0; i < jobList.size();i++) {
			jobList.get(i);
		}
		
		model.addAttribute("jobList", jobList);
		
		return "commu/jobs.tiles";
	}
	
	@RequestMapping(value = "/commu/uploadReview", method = RequestMethod.GET)
	public String uploadReview(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		
		
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

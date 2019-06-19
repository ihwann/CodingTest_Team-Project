package com.stevelee.java.control;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(value = "review", method = RequestMethod.GET)
	public String listReview(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<ReviewDto> reviewList = dao.select_all_review();
	
		ArrayList<String> compList = dao.select_all_review_comp();
		
				
		model.addAttribute("compList", compList);
		model.addAttribute("reviewList", reviewList);

		
		return "commu/review.tiles";
	}
	
	
	
//	@RequestMapping(value = "/commu/jobs", method = RequestMethod.GET)
//	public String listJobs(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//		
//		JobDao dao = sqlSession.getMapper(JobDao.class);
//		ArrayList<JobDto> jobList = dao.select_all_job();
//		
//		
//		model.addAttribute("jobList", jobList);
//		
//		return "commu/jobs.tiles";
//	}
	
	@RequestMapping(value = "showReview", method = RequestMethod.GET)
	public String showReview(Model model,
		     @RequestParam(value="id") int id) throws Exception {

		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ReviewDto review = dao.select_review(id);
		
		model.addAttribute("review", review);
		
		return "commu/showReview.tiles";
	}
	
	@RequestMapping(value = "uploadReview", method = RequestMethod.GET)
	public String uploadReviewForm(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<String> compList = dao.select_all_review_comp();
		model.addAttribute("compList", compList);
		
		return "commu/uploadAndModifyReview.tiles";
	}
	
	@RequestMapping(value = "uploadReview", method = RequestMethod.POST)
	public String uploadReview(@ModelAttribute ReviewDto review, RedirectAttributes redirectAttribute) throws Exception {
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);

		
		redirectAttribute.addFlashAttribute("review", review);
		
		
		String tempId = "tempId1";
		review.setReview_user(tempId);
		review.setReview_title(new String(review.getReview_title().getBytes("8859_1"), "UTF-8"));
		review.setReview_comp(new String(review.getReview_comp().getBytes("8859_1"), "UTF-8"));
		review.setReview_content(new String(review.getReview_content().getBytes("8859_1"), "UTF-8"));
			
		int res = dao.insert_review(review);
		
		return "redirect:review";
	}
	
	
//	@RequestMapping(value = "/commu/uploadJobs", method = RequestMethod.GET)
//	public String uploadJobs(Locale locale, Model model) {
//		
//		
//		return "commu/uploadAndModifyJob.tiles";
//	}
//	
	@RequestMapping(value = "modifyReview", method = RequestMethod.GET)
	public String modifyReview(Model model,
		     @RequestParam(value="id") int id) throws Exception {

		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ReviewDto review = dao.select_review(id);
		
		model.addAttribute("review", review);
		return "commu/uploadAndModifyReview.tiles";
	}
	
//	@RequestMapping(value = "/commu/modifyJobs", method = RequestMethod.GET)
//	public String modifyJobs(Locale locale, Model model) {
//		
//		
//		return "commu/uploadAndModifyJob.tiles";
//	}
}

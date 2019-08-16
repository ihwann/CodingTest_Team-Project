package com.stevelee.java.control;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stevelee.java.dao.JobDao;
import com.stevelee.java.dao.ReviewDao;
import com.stevelee.java.dao.TestDao;
import com.stevelee.java.dao.TestMakeDao;
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
		
		/*
		String rtn = (String)request.getAttribute("rtn2");
		System.out.println("rtn:" + rtn);
		*/
		
		model.addAttribute("compList", compList);
		model.addAttribute("reviewList", reviewList);

		return "commu/review.tiles";
	}
	
	
	//job list 화면 호출 
	@RequestMapping(value = "jobs", method = RequestMethod.GET)
	public String listJobs(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		JobDao dao = sqlSession.getMapper(JobDao.class);
		ArrayList<JobDto> jobList = dao.select_all_job();

		ArrayList<String> job_main_lang_list = dao.select_all_job_main_lang();
		ArrayList<String> job_field_list = dao.select_all_job_field();
		ArrayList<String> job_loc_list = dao.select_all_job_loc();
		
		
		model.addAttribute("job_main_lang_list", job_main_lang_list);
		model.addAttribute("job_field_list", job_field_list);
		model.addAttribute("job_loc_list", job_loc_list);
		
		model.addAttribute("jobList", jobList);
		
		return "commu/jobs.tiles";
	}
	
	//review 화면 호출 
	@RequestMapping(value = "showReview", method = RequestMethod.GET)
	public String showReview(HttpServletRequest request, HttpServletResponse response,Model model,
		     @RequestParam(value="id") int id) throws Exception {

		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ReviewDto review = dao.select_review(id);
		
		model.addAttribute("review", review);
		
		return "commu/showReview.tiles";
	}

	//job 화면 호출 
	@RequestMapping(value = "showJob", method = RequestMethod.GET)
	public String showJob(HttpServletRequest request, HttpServletResponse response,Model model,
		     @RequestParam(value="id") int id) throws Exception {

		JobDao dao = sqlSession.getMapper(JobDao.class);
		JobDto job = dao.select_job(id);
		
		model.addAttribute("job", job);
		
		return "commu/showjob.tiles";
	}
	
	//review 업로드 폼 
	@RequestMapping(value = "uploadReview", method = RequestMethod.GET)
	public String uploadReviewForm(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		String id = request.getParameter("id");
		System.out.println("review id:" + id);
		
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<String> compList = dao.select_all_review_comp();
		model.addAttribute("compList", compList);
		
		return "commu/uploadAndModifyReview.tiles";
		//return "commu/uploadAndModifyReview";
	}

	
	//review 업로드 폼 
	@RequestMapping(value = "uploadReview2", method = RequestMethod.GET)
	public String uploadReviewForm2(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		
		String id = request.getParameter("id");
		System.out.println("review id:" + id);
		
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<String> compList = dao.select_all_review_comp();
		model.addAttribute("compList", compList);
		
		//return "commu/uploadAndModifyReview.tiles";
		return "commu/uploadAndModifyReview2";
	}
	//review upload
	@RequestMapping(value = "uploadReview", method = RequestMethod.POST)
	public String uploadReview(HttpServletRequest request, HttpServletResponse response,@ModelAttribute ReviewDto review, RedirectAttributes redirectAttribute) throws Exception {
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);

		
		redirectAttribute.addFlashAttribute("review", review);
		
		System.out.println("review.getReview_title():" + review.getReview_title());
		String tempId = "tempId1";
		review.setReview_user(tempId);
		
		/*
		review.setReview_title(new String(review.getReview_title().getBytes("8859_1"), "UTF-8"));
		review.setReview_comp(new String(review.getReview_comp().getBytes("8859_1"), "UTF-8"));
		review.setReview_content(new String(review.getReview_content().getBytes("8859_1"), "UTF-8"));
		*/
		
		review.setReview_title(review.getReview_title());
		review.setReview_comp(review.getReview_comp());
		review.setReview_content(review.getReview_content());
			
		int res = dao.insert_review(review);
		
		return "redirect:review";
//		return "commu/review.tiles";
	}
	
	//upload job form
	@RequestMapping(value = "uploadJob", method = RequestMethod.POST)
	public String uploadJob(HttpServletRequest request, HttpServletResponse response,@ModelAttribute JobDto job, RedirectAttributes redirectAttribute) throws Exception {
		JobDao dao = sqlSession.getMapper(JobDao.class);

		redirectAttribute.addFlashAttribute("job", job);
		
		String tempId = "tempId1";
		job.setJob_user(tempId);
		job.setJob_title(new String(job.getJob_title().getBytes("8859_1"), "UTF-8"));
		job.setJob_content(new String(job.getJob_content().getBytes("8859_1"), "UTF-8"));
		job.setJob_main_lang(new String(job.getJob_main_lang().getBytes("8859_1"), "UTF-8"));
		job.setJob_field(new String(job.getJob_field().getBytes("8859_1"), "UTF-8"));
		job.setJob_loc(new String(job.getJob_loc().getBytes("8859_1"), "UTF-8"));
		job.setJob_smsi(new String(job.getJob_smsi().getBytes("8859_1"), "UTF-8"));
			
		int res = dao.insert_job(job);
		
		return "redirect:jobs";
	}
	
	//upload job
	@RequestMapping(value = "uploadJob", method = RequestMethod.GET)
	public String uploadJobForm(HttpServletRequest request, HttpServletResponse response, Model model)  throws Exception{
		JobDao dao = sqlSession.getMapper(JobDao.class);

		ArrayList<String> job_main_lang_list = dao.select_all_job_main_lang();
		ArrayList<String> job_field_list = dao.select_all_job_field();
		ArrayList<String> job_loc_list = dao.select_all_job_loc();
	
		
		model.addAttribute("job_main_lang_list", job_main_lang_list);
		model.addAttribute("job_field_list", job_field_list);
		model.addAttribute("job_loc_list", job_loc_list);
		
		return "commu/uploadAndModifyJob.tiles";
	}

	
	//특정 review 삭제 
	@RequestMapping(value = "deleteReview", method = RequestMethod.GET)
	public String deleteReview(HttpServletRequest request, HttpServletResponse response,Model model,
		     @RequestParam(value="id") int id) throws Exception {

		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		int result = dao.delete_review(id);
		model.addAttribute("rtn", result);
		
		//request.setAttribute("rtn2", Integer.toString(result));
		
		return "forward:review";
		//return "redirect:review";
		//return "commu/review.tiles";
	}
	
	//특정 job 삭제 
	@RequestMapping(value = "deleteJob", method = RequestMethod.GET)
	public String deleteJob(HttpServletRequest request, HttpServletResponse response,Model model,
		     @RequestParam(value="id") int id) throws Exception {

		JobDao dao = sqlSession.getMapper(JobDao.class);
		int result = dao.delete_job(id);
		model.addAttribute("rtn", result);
		
		return "forward:jobs";
	}
	
	//review - search keyword
	@ResponseBody
	@RequestMapping(value = "searchReviewKeywordAjax", method = RequestMethod.POST)
	public void searchReviewKeywordAjax(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
    		
		String compName = request.getParameter("compName");
		String catName = request.getParameter("categoryName");
		String keyName = request.getParameter("keywordName");

		System.out.println("SearchReviewKeywordAjaxController");

		System.out.println(compName+":"+catName+":"+keyName);
		Map<String, String> map = new HashMap<String, String>(); // MAP을 이용해 담기
		map.put("compName", compName);
		map.put("catName", catName);
	    map.put("keyName", keyName);
	    
	    
		ReviewDao reviewdao = sqlSession.getMapper(ReviewDao.class);
		ArrayList<ReviewDto> reviewList = reviewdao.select_search_review(map);
		
		JSONArray jarry = new JSONArray();
		
		for(int i = 0; i < reviewList.size(); i++) {
    		JSONObject jobj = new JSONObject();
    		jobj.put("jno", reviewList.get(i).getReview_num());
    		jobj.put("jtitle", reviewList.get(i).getReview_title());
    		jobj.put("juser", reviewList.get(i).getReview_user());
    		jobj.put("jdate", reviewList.get(i).getReview_date());
    		jarry.add(jobj);
    	}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = response.getWriter();		

		out.print(jarry.toString());
		
		out.flush();
		out.close();
	}
	
	//job - search keyword
	@ResponseBody
	@RequestMapping(value = "searchJobKeywordAjax", method = RequestMethod.POST)
	public void searchJobKeywordAjax(  HttpSession session, Model model
    		, @RequestBody String jsonList
    		, HttpServletRequest request
    		, HttpServletResponse response
    		) throws Exception {
		
		

		System.out.println("SearchJobKeywordAjaxController");
		System.out.println("jsonList:" + jsonList);
		
		JSONParser json = new JSONParser();
    	JSONArray str = (JSONArray)json.parse(jsonList);
    	


    	
    	for(int num = 0; num < str.size(); num++) {
    		String[] arr = new String[4];
    		
    		
    		 arr[num] = str.get(num).toString().substring(1, str.get(num).toString().length()-1);

    		 String[] subArr = new String[arr[num].length()];
    		 subArr = arr[num].split(",");
    		 for(int i = 0; i < subArr.length;i++) {
    			 String word = subArr[i].substring(1, subArr[i].length()-1);
    			 
    			 if(num == 0) { //lang
    				 
    			 }else if(num == 1) { // field
    				 
    			 }else if(num == 2) { //loc
    				 
    			 }else if(num == 3) { //smsi
    			 
    			 
    		 }
    	}
    		
    		
    		
    	}

//		JSONParser json = new JSONParser();
//    	JSONArray obj = (JSONArray)json.parse(langList);
//		
//    	
//    	System.out.println(obj);
	    
	}
	
	
//	@RequestMapping(value = "/commu/modifyJobs", method = RequestMethod.GET)
//	public String modifyJobs(Locale locale, Model model) {
//		
//		
//		return "commu/uploadAndModifyJob.tiles";
//	}
	
	@RequestMapping(value = "modifyReview", method = RequestMethod.GET)
	public String modifyReview(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		
		String reviewnum = request.getParameter("reviewnum");
		System.out.println("modifyReview2:" + reviewnum);
		
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ReviewDto review = dao.select_review(Integer.parseInt(reviewnum));
		
		System.out.println("Review_comp:" + review.getReview_comp());

		model.addAttribute("review", review);
		
		return "forward:uploadReview2";
	}
	
}

package com.stevelee.java.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stevelee.java.dao.AnalyticsDao;
import com.stevelee.java.dto.TestDto;


@Controller
public class AnalyticsController {
	
	HttpSession session;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	public String overview(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		System.out.println("overview");
		
		String analyticsJson = null;
		String analyticsCateSuccJson = null;
		List<Map<String, Object>> analyticsList = null;
		List<Map<String, Object>> analyticsCateSuccList = null;
		//JSONArray result = new JSONArray();
		session = request.getSession();
		Object obj = session.getAttribute("email");
		
		System.out.println("obj : " + obj);
		String email ="";
		if (obj != null) email = (String)obj;
		
		try {
			AnalyticsDao analyticsDao = sqlSession.getMapper(AnalyticsDao.class);
			ObjectMapper om = new ObjectMapper();
			
			
			analyticsList = analyticsDao.select_analytics_result(email);
			
			analyticsJson = om.writeValueAsString(analyticsList);
			
			analyticsCateSuccList = analyticsDao.select_analytics_cate_succ_result(email);
			
			analyticsCateSuccJson = om.writeValueAsString(analyticsCateSuccList);
			/*
			for (int i=0; i<analyticsList.size(); i++) {
				JSONObject jobj = new JSONObject();
				jobj.put("test_no", analyticsList.get(i).get("test_no"));
				jobj.put("test_cate", analyticsList.get(i).get("test_cate"));
				jobj.put("test_type", analyticsList.get(i).get("test_type"));
				jobj.put("test_title", analyticsList.get(i).get("test_title"));
				jobj.put("test_result", analyticsList.get(i).get("test_result"));
				jobj.put("test_result_regi", analyticsList.get(i).get("test_result_regi"));
				result.add(jobj);
			}
			*/
			
			System.out.println("analyticsJson : " + analyticsJson);
			System.out.println("analyticsList : " + analyticsList);
			System.out.println("analyticsCateSuccList : " + analyticsCateSuccList);
			System.out.println("analyticsCateSuccJson : " + analyticsCateSuccJson);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
		
		model.addAttribute("analyticsJson", analyticsJson);
		model.addAttribute("analyticsList", analyticsList);
		model.addAttribute("analyticsCateSuccJson", analyticsCateSuccJson);
		
		return "analy/overview.tiles";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response,ModelMap model) throws Exception {
		
		List<HashMap<String, Object>> hanqPieList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
	      
		hashMap.put("percent", 1);
		hashMap.put("country", "한국");
	      
		hashMap2.put("percent", 2);
		hashMap2.put("country", "러시아");
	      
		hashMap3.put("percent", 3);
		hashMap3.put("country", "이태리");
		
		hanqPieList.add(hashMap);
		hanqPieList.add(hashMap2);
		hanqPieList.add(hashMap3);
		
		model.addAttribute("hanqPieList", hanqPieList);
		
		return "analy/test";
	}
}

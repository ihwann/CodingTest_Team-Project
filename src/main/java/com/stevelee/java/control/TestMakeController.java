package com.stevelee.java.control;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

import com.stevelee.java.comm.Paging;
import com.stevelee.java.dao.TestMakeDao;
import com.stevelee.java.dto.TestmakeCateDto;
import com.stevelee.java.dto.TestmakeContentsDto;
import com.stevelee.java.dto.TestmakeSenttype;
import com.stevelee.java.dto.TestmakeTitleDto;
import com.stevelee.java.dto.TestviewListDto;


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
	 
	

	 @RequestMapping(value = "/index", method = RequestMethod.GET)
	 public String index(Model model) {
	  
	  return "index.tiles";  //
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
	 
	 /*
		//ajax 사용 예제
	    @RequestMapping(value="saveAjaxex1")
	    public void saveAjax (  HttpSession session, Model model
	    		, Map<String, Object> modelMap
	    		, HttpServletRequest request
	    		, HttpServletResponse response
	    		) throws Exception {
	    	
	    	System.out.println("saveAjax");
	    	
	    	String test_title_id = request.getParameter("test_title_id");
	    	String testcateitem_select_id = request.getParameter("testcateitem_select_id");
	    	String testtypebasic_select_id = request.getParameter("testtypebasic_select_id");
	    	String testtypess_select_id = request.getParameter("testtypess_select_id");
	    	String testtypeitem_select_id = request.getParameter("testtypeitem_select_id");
	    	String test_sent_id = request.getParameter("test_sent_id");
	    	
	    	String type = "";
	    	
	    	TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
	    	int maxno = testdao.selectmax_testmake_title();
	    	System.out.println("maxno:" + maxno);
	    	
	    	if("basic".equals(testtypebasic_select_id)) type = testtypess_select_id;
	    	else type = testtypess_select_id;
	    	
	    	maxno++;
	    	int rnttitle = testdao.insert_testmake_title(new TestmakeTitleDto(maxno, testcateitem_select_id, type, test_title_id));
	    	System.out.println("rnttitle:" + rnttitle);
	    	
	    	int sent_no = 1;
	    	int rntcontents = testdao.insert_testmake_contents(new TestmakeContentsDto(maxno, testtypeitem_select_id, sent_no, test_sent_id));
	    	System.out.println("rntcontents:" + rntcontents);
	    	
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
	  */

		//ajax 사용 예제
	    @RequestMapping(value="saveAjax", method=RequestMethod.POST)
	    @ResponseBody
	    public void saveAjax2 (  HttpSession session, Model model
	    		, @RequestBody String jsonList
	    		//, Map<String, Object> jsonList
	    		, HttpServletRequest request
	    		, HttpServletResponse response
	    		) throws Exception {
	    	
	    	System.out.println("saveAjax2");
	    	
	    	System.out.println("jsonList:" + jsonList);
	    	
	    	JSONParser json = new JSONParser();
	    	JSONObject obj = (JSONObject)json.parse(jsonList);
	    	
	    	//System.out.println("obj.get(\"test_title_id\"):" + obj.get("test_title_id"));

	    	String test_title_id = (String) obj.get("test_title_id");
	    	String testcateitem_select_id = (String) obj.get("testcateitem_select_id");
	    	String testtypebasic_select_id = (String) obj.get("testtypebasic_select_id");
	    	String testtypess_select_id = (String) obj.get("testtypess_select_id");
	    	
	    	
	    	JSONArray obj2 = (JSONArray)obj.get("dataArray");
	    	System.out.println("obj2:" + obj2);
	    	
	    	String type = "";
	    	
	    	TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
	    	int maxno = testdao.selectmax_testmake_title();
	    	System.out.println("maxno:" + maxno);
	    	
	    	if("basic".equals(testtypebasic_select_id)) type = testtypess_select_id;
	    	else type = testtypess_select_id;
	    	
	    	maxno++;
	    	int rnttitle = testdao.insert_testmake_title(new TestmakeTitleDto(maxno, testcateitem_select_id, type, test_title_id));
	    	System.out.println("rnttitle:" + rnttitle);
	    	
	    	int sent_no = 1;

	    	
	    	
	    	
	    	for(int num = 0; num < obj2.size(); num++) {
	    		/*
	    		JSONObject obj3 = (JSONObject) obj2.get(num);
	    		System.out.println("obj3 type:" + obj3.get("type"));
	    		System.out.println("obj3 contents:" + obj3.get("contents"));
	    		*/
	    		//System.out.println("obj2:" + obj2.get(num));
	    		
	    		JSONObject obj3 = (JSONObject)json.parse(obj2.get(num).toString());
	    		
	    		/*
	    		System.out.println("obj3 type:" + obj3.get("type"));
	    		System.out.println("obj3 contents:" + obj3.get("contents"));
	    		*/
	    		
		    	int rntcontents = testdao.insert_testmake_contents(new TestmakeContentsDto(maxno, obj3.get("type").toString(), sent_no, obj3.get("contents").toString()));
		    	System.out.println("rntcontents:" + rntcontents);
		    	sent_no++;
	    	}
	    	
	    	//JSONArray.fromObject(jsonList);
	    	
	    	/*
   	    	JSONParser json = new JSONParser();
	    	json.parse(jsonList);
	        List<Map<String,Object>> resultMap = new ArrayList<Map<String,Object>>();
	        resultMap = JSONArray.fromObject(jsonList);
	             
	        for (Map<String, Object> map : resultMap) {
	            System.out.println(map.get("user_nm") + " : " + map.get("user_password"));
	            //관리자 : 1111
	            //직원 : 2222
	        }


	    	
	    	
	    	String paramName = String.valueOf(jsonList.get(0).get("test_title_id"));
	    	System.out.println("paramName:" + paramName);
	    	
	    	HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    	*/
	    	
	    	
	    	//String jsonParam = request.getParameter(JsonKeyInfo.PARAM_KEY_JSON);


	    }
	    


		 @RequestMapping(value = "/testview", method = RequestMethod.GET)
		 public String testview(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
			 

			TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
			
			
			String curpage = request.getParameter("curpage");
			int curpagenum = 1;
			//Integer.parseInt(
			if(curpage != null) curpagenum = Integer.parseInt(curpage);
			
			// 페이징처리
	        int listCnt = testdao.selectlist_testview_list_cnt();
	        
	        Paging pagination = new Paging(listCnt, curpagenum);
	        
	                
	        model.addAttribute("listCnt", listCnt);
	        model.addAttribute("pagination", pagination);
	        
	        // 리스트
			ArrayList<TestviewListDto> testviewlist = testdao.selectlist_testview_list(pagination.getStartIndex(),pagination.getPageSize());
			ArrayList<TestmakeContentsDto> testcontentslist = testdao.selectlist_testmake_contents(5);
		  
			model.addAttribute("testviewlist", testviewlist);
			model.addAttribute("testcontentslist", testcontentslist);


		  return "test/testview.tiles";  //

		 }
		 
		 @ResponseBody
		 @RequestMapping(value = "/testpreviewAjax", method = RequestMethod.POST)
		 public void testpreviewAjax(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
			 
			 int testnoid = Integer.parseInt(request.getParameter("testnoid"));
			 System.out.println("testnoid:" + testnoid);
			 
			 
			 TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
			 ArrayList<TestmakeContentsDto> testcontentslist = testdao.selectlist_testmake_contents(testnoid);
			 
			 
		    	
		    	
		    	JSONArray jarry = new JSONArray();
		    	
		    	for(int i = 0; i < testcontentslist.size(); i++) {
		    		JSONObject jobj = new JSONObject();
		    		jobj.put("sent_type", testcontentslist.get(i).getSent_type());
		    		jobj.put("sent_cont", testcontentslist.get(i).getSent_cont());
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
}

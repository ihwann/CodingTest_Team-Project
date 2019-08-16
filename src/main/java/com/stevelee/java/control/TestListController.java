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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.java.comm.Paging;
import com.stevelee.java.dao.TestMakeDao;
import com.stevelee.java.dto.TestmakeContentsDto;
import com.stevelee.java.dto.TestviewListDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestListController {

	HttpSession session;

	@Autowired
	private SqlSession sqlSession;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "testListAjax")
	@ResponseBody
	public void testListAjax(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		int testnoid = Integer.parseInt(request.getParameter("testnoid"));
		System.out.println("testnoid:" + testnoid);

		TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);
		ArrayList<TestmakeContentsDto> testcontentslist = testdao.selectlist_testmake_contents(testnoid);

		JSONArray jarry = new JSONArray();

		for (int i = 0; i < testcontentslist.size(); i++) {
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

	@RequestMapping(value = "/testlist", method = RequestMethod.GET)

	public String testlist(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

		TestMakeDao testdao = sqlSession.getMapper(TestMakeDao.class);

		String curpage = request.getParameter("curpage");
		int curpagenum = 1;
		// Integer.parseInt(
		if (curpage != null)
			curpagenum = Integer.parseInt(curpage);

		// 페이징처리
		int listCnt = testdao.selectlist_testview_list_cnt();

		Paging pagination = new Paging(listCnt, curpagenum);

		model.addAttribute("listCnt", listCnt);
		model.addAttribute("pagination", pagination);

		// 리스트
		ArrayList<TestviewListDto> testviewlist = testdao.selectlist_testview_list(pagination.getStartIndex(),
				pagination.getPageSize());
		ArrayList<TestmakeContentsDto> testcontentslist = testdao.selectlist_testmake_contents(5);

		model.addAttribute("testviewlist", testviewlist);
		model.addAttribute("testcontentslist", testcontentslist);

		return "test/testlist.tiles"; //

	}

}

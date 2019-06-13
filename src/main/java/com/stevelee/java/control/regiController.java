package com.stevelee.java.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stevelee.java.dto.regi_UserDto;
import com.stevelee.java.service.regi_UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class regiController {

	HttpSession session;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private regi_UserService regi_service;

	// 회원가입 화면 RequestMapping
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String regi(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원가입화면");

		return "user/regi.tiles"; //

	}

	// 이용약관 화면 RequestMapping
	@RequestMapping(value = "/TermsConditions", method = RequestMethod.GET)
	public String TermsConditions(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/TermsConditions.tiles"; //

	}

	// 회원가입 컨트롤러
	@RequestMapping(value = "/regiControl", method = RequestMethod.POST)
	public String regiControl(regi_UserDto udto) throws Exception {
		// 회원가입 메서드
		System.out.println("회원가입메서드");
		regi_service.userRegiService(udto);
		return "user/regi_success.tiles";
	}

	// 이메일 중복체크 컨트롤러
	@RequestMapping(value = "/eMailchk", method = RequestMethod.POST)
	@ResponseBody // 필요한 이유 파악
	public int eMailchk(@RequestParam("user_eMail") String user_eMail) throws Exception {
		// 이메일 중복체크 메서드
		System.out.println("이메일 중복체크메서드");
		return regi_service.userEmailChk(user_eMail);
	}
	
	// 닉네임 중복체크 컨트롤러
	@RequestMapping(value = "/nickchk", method = RequestMethod.POST)
	@ResponseBody // 필요한 이유 파악
	public int nickchk(@RequestParam("user_nickName") String user_nickName) throws Exception {
		// 닉네임 중복체크 메서드
		System.out.println("닉네임 중복체크메서드");
		return regi_service.usernickChk(user_nickName);
	}

	// 회원가입 완료 화면 매핑
	@RequestMapping(value = "/regi_success", method = RequestMethod.GET)
	public String regi_success(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "user/regi_success.tiles"; //

	}

	// 이용약관 동의체크 RequestMapping
	/*
	 * @RequestMapping(value = "/java/regi") public ModelAndView
	 * termSubmit(@RequestParam(value="agree", defaultValue="false") Boolean agree)
	 * throws Exception { if(!(agree)) { ModelAndView mv = new
	 * ModelAndView("user/TermsConditions.tiles"); return mv; }else { ModelAndView
	 * mv = new ModelAndView("/user/regi.tiles"); //mv.addObject("registerRequest",
	 * new RegisterRequest()); return mv; } }
	 */

}

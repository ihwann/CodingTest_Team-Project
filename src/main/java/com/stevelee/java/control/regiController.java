package com.stevelee.java.control;

import javax.servlet.ServletRequest;
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
import com.stevelee.java.service.regi_randomNum;
import com.stevelee.java.service.regi_sendEmailService;

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

	@Autowired
	private regi_randomNum randomNum_service;

	@Autowired
	private regi_sendEmailService sendEmailService;

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
	public String regiControl(regi_UserDto udto, ServletRequest request) throws Exception {
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

	// 이메일 인증 컨트롤러
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	@ResponseBody
	public String sendEmail(@RequestParam("user_eMail") String user_eMail, HttpServletRequest request)
			throws Exception {
		String email_addr = user_eMail;
		String authNum = "";
		// 난수 생성
		authNum = randomNum_service.create_randomNum();

		// System.out.println(email_addr + " 이메일 인증");
		// System.out.println(authNum);

		// 생성된 난수와 전송한 메일을 세션에 담기
		session = request.getSession();
		session.setAttribute("authNum", authNum);
		session.setAttribute("email_addr", email_addr);

		StringBuffer resultAuth = new StringBuffer();

		String authKey = (String) request.getSession().getAttribute("authNum");
		String authEmail = (String) request.getSession().getAttribute("email_addr");
		String sessionID = session.getId();

		// 난수값+이메일+세션ID 합치기
		resultAuth.append(authKey);
		resultAuth.append(sessionID);
		resultAuth.append(authEmail);
		System.out.println(resultAuth);

		// 생성한 난수를 이메일로 보내기
		sendEmailService.send_Email(email_addr, authNum);

		return resultAuth.toString();
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

}

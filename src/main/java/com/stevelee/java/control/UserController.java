package com.stevelee.java.control;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.xml.ws.Response;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.stevelee.java.dao.regiUserDao;
import com.stevelee.java.dto.regi_UserDto;
import com.stevelee.java.service.UserService;
import com.stevelee.java.service.regi_userConvertSHA256Service;

@Controller
public class UserController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private UserService userService;
	
	private HttpSession session;
	
	
	@Autowired
	private regi_userConvertSHA256Service convert_SHA256;
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "user/login.tiles";
	}
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		session = request.getSession();
		
		if (session.getAttribute("email") != null) {
			session.removeAttribute("email");
		}
		
		String email = request.getParameter("email1");
		System.out.println("email = " + email);

		String pw = request.getParameter("pw");
		System.out.println("pw = " + pw);
		
		// 암호화를 위한 것임
		String user_pwSHA256 = convert_SHA256.encrypt(pw);
		System.out.println(user_pwSHA256);
		
		
		
		String chkBox = request.getParameter("chk");
		
		System.out.println(chkBox);
		
		int check = Integer.parseInt(chkBox);
		
		System.out.println("check = " + check);
		
		regi_UserDto regiUserDto = new regi_UserDto();
		
		regi_UserDto idCheck = userService.selectGeneralIdCheck(email);
		
		
		
		
		if (idCheck.getUser_eMail().equals(email)) {
			
			if (idCheck.getUser_pw().equals(user_pwSHA256)) {
		  		// 암호화되면 확인 필요 -> equals(user_pwSHA256)
				// regi부분이 오류나서 확인 못함
				
				if (check == 1) { // 완전 로그인 되었을 때  수정되게 하기 
					 
					System.out.println(3);
					
					regiUserDto.setUser_eMail(email);
					
					regiUserDto.setUser_check(check);
					
					int result = userService.cookieUpdate(regiUserDto);
					
					
				}
				session.setAttribute("email", email);
		 		
		  		System.out.println(regiUserDto.getUser_check());
			 		
			 	if (regiUserDto.getUser_check() == 1) { 
			 		
			 		System.out.println(6); 
			 		
			 		Cookie cookie = new Cookie("loginCheck", session.getId());
			  		
			  		cookie.setPath("/");
			 		
			 		int amount = 60 * 60 * 24 * 7;
			  		
			  		cookie.setMaxAge(amount);
			  
			  		response.addCookie(cookie);
			 	
			  		Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			  		
			  		System.out.println(session.getId());
			  		
			  		userService.keepLogin(email, session.getId(), sessionLimit);
			  		
			  		
			 	}
		  
		 		model.addAttribute("loginCheck", "allOk");
		 		System.out.println("로그인 성공");
		 		
		  } else {
			  
			  	model.addAttribute("loginCheck", "idOk");
			  	System.out.println("로그인 실패1");
			  	
		  }
	} else { 
		
		model.addAttribute("loginCheck", "fail");
		System.out.println("로그인 실패2");
	}
		 
		return "user/loginIng.tiles";
	}
	
	@RequestMapping(value = "/loginIng", method = RequestMethod.GET)
	public String loginIng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "user/loginIng.tiles";
	}
	
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		
		session = request.getSession();
		
		Object obj = session.getAttribute("email");
		
		System.out.println("obj : " + obj);
		
		if (obj != null) {
			String email = (String)obj;
			
			System.out.println("email : " + email);
			
			regi_UserDto regiUserDto = new regi_UserDto(); 
			
			
			
			
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			System.out.println(loginCookie);
			
			if (loginCookie != null) {
				loginCookie.setPath("/");
				
				loginCookie.setMaxAge(0);
				
				response.addCookie(loginCookie);
				
				Date date = new Date(System.currentTimeMillis());
				
				userService.keepLogin(email, session.getId(), date);
				
				
			} else {
				
				int check = 0;
				
				regiUserDto.setUser_eMail(email);
				
				regiUserDto.setUser_check(check);
				
				int result = userService.cookieUpdate(regiUserDto);
				
			}
			
			
			
			session.removeAttribute("email");
			
			session.invalidate();
		}
		

		
		
		return "user/logout.tiles";
	}
}


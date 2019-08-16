package com.stevelee.java.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.stevelee.java.dto.regi_UserDto;
import com.stevelee.java.service.UserService;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("email");
		
		if (obj == null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			String sessionId = loginCookie.getValue();
			
			regi_UserDto regiUserDto = userService.checkUserWithSessionKey(sessionId);
		
			if (regiUserDto != null) {
				session.setAttribute("email", regiUserDto);
				return true;
			}
		}
		response.sendRedirect("/java/login");
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		super.postHandle(request, response, handler, modelAndView);
		
	}
}

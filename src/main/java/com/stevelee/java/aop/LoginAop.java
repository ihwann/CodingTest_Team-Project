package com.stevelee.java.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.ui.Model;

public class LoginAop { 
	
	@Around("login2()")
	public Object trace(ProceedingJoinPoint joinPoint) throws
	 				Throwable{
	
		 	System.out.println("#### LoginAspect 시작 ####");
		 	HttpServletRequest request = null; 
		 	  HttpServletResponse response = null;
		 	
			  for ( Object o : joinPoint.getArgs() ){
				  if ( o instanceof HttpServletRequest ) { 
					  	request = (HttpServletRequest)o; 
				  }
				  if ( o instanceof HttpServletResponse ) { 
					  response = (HttpServletResponse)o;
				  } 
			  }
	  
			  System.out.println("request = " + request);
	  
			  System.out.println("response = " + response);
	 
			  String strUrl = request.getRequestURL().toString();
	  
			  System.out.println("strUrl : " + strUrl); //로그인 페이지 제외
			  
			  System.out.println(strUrl.endsWith("/review") || strUrl.endsWith("/jobs") ||
			  strUrl.endsWith("/testmake") || strUrl.endsWith("/testlist") ||
			  strUrl.endsWith("/overview"));
			 
			  if(strUrl.endsWith("/review") || strUrl.endsWith("/jobs") ||
			  strUrl.endsWith("/testmake") || strUrl.endsWith("/testlist") ||
			  strUrl.endsWith("/overview") || strUrl.endsWith("/testcoding") || strUrl.endsWith("/codingtest") || strUrl.endsWith("/showReview")) {
				  
				  HttpSession session = request.getSession(); // StoreDto sdto = (StoreDto)
				  // session.getAttribute("sdto"); 
				  String email = (String)session.getAttribute("email");
				  
				  System.out.println(email);
			  
				  if (email == null) { 
					  return "user/loginSession.tiles"; 
				  }
			  }
			  
			  System.out.println("#### LoginAspect 끝 ####"); 
		 
		 	Object result = joinPoint.proceed();
		 	return result;
		 }
 }
 
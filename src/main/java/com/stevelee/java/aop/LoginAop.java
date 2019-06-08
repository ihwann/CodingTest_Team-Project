package com.stevelee.java.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

//import com.steveleejava.phoneStore.dto.StoreDto;

public class LoginAop {
	//public * *..*Controller.*(..)
	//@Pointcut("execution(public * com.steveleejava.springstep1.contorl.*Controller.*(..))")
	/*@Pointcut("execution(public * *..*Controller.*(..))")
	private void login2(){}



	@Around(value="login2()")*/
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
    	 
    	System.out.println("#### LoginAspect 시작 ####");  
    	
    	
    	/*
    	
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
        
        
        System.out.println(11);
        
        try{
        	
        	System.out.println(1);
        	
        	String strUrl = request.getRequestURL().toString();

        	System.out.println("strUrl : " + strUrl);
        	//로그인 페이지 제외

        	if(!strUrl.endsWith("/login") && !strUrl.endsWith("/loginchk")
        			//|| !strUrl.endsWith("/regiuser") || !strUrl.endsWith("/regi")
        			 && !strUrl.endsWith("/joinchk") && !strUrl.endsWith("/join") && !strUrl.endsWith("/jqueryjsp") && !strUrl.endsWith("/dynamicform")
        			 && !strUrl.endsWith("/ajaxjqueryjsp") && !strUrl.endsWith("/ajaxjquery")){



        		System.out.println(2);
        	
    			
        		HttpSession session = request.getSession();
    			StoreDto sdto = (StoreDto) session.getAttribute("sdto");
 
                if (sdto == null ) {

                    throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
                }   
                
                
                
        	}
        	
        }catch(Exception e){
             
            throw new RuntimeException("먼저 로그인을 하셔야 합니다.");
 
        }   
        */
        Object result = joinPoint.proceed();
        System.out.println("#### LoginAspect 끝 ####");     
        return result;
        
        
    }


	
}

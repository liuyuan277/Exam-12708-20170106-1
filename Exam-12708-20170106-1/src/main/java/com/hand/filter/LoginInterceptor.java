package com.hand.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final String[] IGNORE_URI ={"/login.html","/user"};

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
         super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		boolean flag=false;
		String url=request.getRequestURL().toString();
		System.out.println("URL:"+url);
		for(String s:IGNORE_URI){
			if (url.contains(s)) {
				flag=true;
				break;
			}			
		}
		if (!flag) {
		  	String  str=(String)request.getSession().getAttribute("OnLineUser");
		  	System.out.println("OnLineUser:"+str);
		  	if (str != null)  flag=true;
		}
		if(!flag){
			response.sendRedirect("login.html");
		}
		return flag;
	}
}

package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		String url = request.getRequestURI();
//		System.out.println(url);
		if (url.indexOf("login") > 0 ) {
			return true;
		}
		

//		---------------------------------------------------------------------
		
		//当请求发送过来,首先确认有没有username对应的值
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("username");
		
		//当name中有值,说明session中存储了用户信息,就让这次请求通过
		if (name != null) {
			return true;
		}
		
		//如果没有,跳转到登录界面
		request.getRequestDispatcher("/WEB-INF/pages/loginpage.jsp").forward(request, response);
		
		
		return false;
	}
	
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	

	

}

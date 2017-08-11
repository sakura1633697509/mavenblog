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
		
		//�������͹���,����ȷ����û��username��Ӧ��ֵ
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("username");
		
		//��name����ֵ,˵��session�д洢���û���Ϣ,�����������ͨ��
		if (name != null) {
			return true;
		}
		
		//���û��,��ת����¼����
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

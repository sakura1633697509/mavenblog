package com.lanou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	public String frontPage() {
		return "index";
	}

	// 到登录界面
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		return "loginpage";
	}

	// 用户界面
	@RequestMapping(value = "/userinfo")
	public String userinfoPage() {
		return "userinfo";
	}

	// -----------------------------------------------------------------------------------

	// form表单请求
	@RequestMapping(value = "/formlogin")
	public String login(HttpServletRequest request, @RequestParam("username") String name,
			@RequestParam("password") String pwd) {
		System.out.println(name + "--------");
		System.out.println(pwd + "--------");

		// 把用户名存储在session中
		// 创建session对象
		HttpSession session = request.getSession();
		
		session.setAttribute("username", name);

		System.out.println(session.getAttribute("username") + "******");

		// 登录成功,重定向到uessrinfo页面
		return "redirect:userinfo";
	}

	// 退出登录
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {

		// 登出就是清除session
		HttpSession session = request.getSession();
		session.invalidate();

		return "loginpage";
	}

	// ===============================复制网页的代码============================================

	private boolean ifFlagExistInSession(HttpServletRequest request) {
		//创建session对象
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("flagName") != null) {
				return true;
			}
		}
		return false;
	}
	
	// ===============================复制网页的代码============================================
	

}

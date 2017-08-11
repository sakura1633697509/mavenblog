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

	// ����¼����
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		return "loginpage";
	}

	// �û�����
	@RequestMapping(value = "/userinfo")
	public String userinfoPage() {
		return "userinfo";
	}

	// -----------------------------------------------------------------------------------

	// form������
	@RequestMapping(value = "/formlogin")
	public String login(HttpServletRequest request, @RequestParam("username") String name,
			@RequestParam("password") String pwd) {
		System.out.println(name + "--------");
		System.out.println(pwd + "--------");

		// ���û����洢��session��
		// ����session����
		HttpSession session = request.getSession();
		
		session.setAttribute("username", name);

		System.out.println(session.getAttribute("username") + "******");

		// ��¼�ɹ�,�ض���uessrinfoҳ��
		return "redirect:userinfo";
	}

	// �˳���¼
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {

		// �ǳ��������session
		HttpSession session = request.getSession();
		session.invalidate();

		return "loginpage";
	}

	// ===============================������ҳ�Ĵ���============================================

	private boolean ifFlagExistInSession(HttpServletRequest request) {
		//����session����
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("flagName") != null) {
				return true;
			}
		}
		return false;
	}
	
	// ===============================������ҳ�Ĵ���============================================
	

}

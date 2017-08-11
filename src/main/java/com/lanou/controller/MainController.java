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
		
//		git²âÊÔ
		
		//´úÂë³åÍ»A
		//°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡°¡
		//¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ¹þ
		
		//********************************************
		
		return "index";
	}
	
	
//	-----------------------------------------------------------------------
	
//	@RequestMapping(value = "/")
//	public String frontPage() {
//		return "index";
//	}

	// µ½µÇÂ¼½çÃæ
	@RequestMapping(value = "/loginpage")
	public String loginPage() {
		return "loginpage";
	}

	// ÓÃ»§½çÃæ
	@RequestMapping(value = "/userinfo")
	public String userinfoPage() {
		return "userinfo";
	}

	// -----------------------------------------------------------------------------------

	// form±íµ¥ÇëÇó
	@RequestMapping(value = "/formlogin")
	public String login(HttpServletRequest request, @RequestParam("username") String name,
			@RequestParam("password") String pwd) {
		System.out.println(name + "--------");
		System.out.println(pwd + "--------");

		// °ÑÓÃ»§Ãû´æ´¢ÔÚsessionÖÐ
		// ´´½¨session¶ÔÏó
		HttpSession session = request.getSession();
		
		session.setAttribute("username", name);

		System.out.println(session.getAttribute("username") + "******");

		// µÇÂ¼³É¹¦,ÖØ¶¨Ïòµ½uessrinfoÒ³Ãæ
		return "redirect:userinfo";
	}

	// ÍË³öµÇÂ¼
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {

		// µÇ³ö¾ÍÊÇÇå³ýsession
		HttpSession session = request.getSession();
		session.invalidate();

		return "loginpage";
	}

	// ===============================¸´ÖÆÍøÒ³µÄ´úÂë============================================

	private boolean ifFlagExistInSession(HttpServletRequest request) {
		//´´½¨session¶ÔÏó
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (session.getAttribute("flagName") != null) {
				return true;
			}
		}
		return false;
	}
	
	// ===============================¸´ÖÆÍøÒ³µÄ´úÂë============================================
	

}

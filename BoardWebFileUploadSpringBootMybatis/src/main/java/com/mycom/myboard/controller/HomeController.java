package com.mycom.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String index() {
		return "index.html";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login.html";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "register.html";
	}
	
	@GetMapping(value = "/board")
	public String board() {
		return "board/boardMain.html";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.html";
	}
}

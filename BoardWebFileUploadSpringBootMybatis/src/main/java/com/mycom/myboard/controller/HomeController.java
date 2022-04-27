package com.mycom.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@GetMapping(value = { "/", "/board"} )
	private String home(){
		return "board/boardMain"; 
	}
	
	@GetMapping(value = "/login")
	private String login(){
		return "login"; 
	}	
	
	@GetMapping(value = "/register")
	private String register(){
		return "register"; 
	}
}

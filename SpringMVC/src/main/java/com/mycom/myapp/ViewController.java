package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {
	
	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		return "viewTest1";
	}
	
	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		return "/sub/viewTest2";
	}
	
	// controller <--> service
	// date : jsp로 보내줄 데이터가 존재
	
	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		model.addAttribute("seq", "12345");
		model.addAttribute("empDto", new EmpDto(1600, "박", "찬호", "park@park.com", "2000-01-01"));
		return "viewTest3";
	}
}

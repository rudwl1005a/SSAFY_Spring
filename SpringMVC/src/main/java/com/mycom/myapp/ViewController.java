package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4() { // 파라미터로 Model 받지 않음
		// 데이터와 jsp를 동시에 구성
		ModelAndView mav = new ModelAndView();
		mav.addObject("seq", "12345");
		mav.addObject("empDto", new EmpDto(1600, "박", "찬호", "park@park.com", "2000-01-01"));
		mav.setViewName("viewTest4");
		return mav;
	}
	
	@GetMapping(value = "/redirect")
	public String viewTest5() {
		System.out.println("redirect !");
		return "redirect:/viewTest1";
	}
}

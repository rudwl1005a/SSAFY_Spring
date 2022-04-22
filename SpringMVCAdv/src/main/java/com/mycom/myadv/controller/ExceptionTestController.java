package com.mycom.myadv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionTestController {

	@GetMapping("/exception")
	public void makeException() throws Exception {
		System.out.println("/exception");
		throw new RuntimeException(); // 예외상황 발생
//		throw new SQLException();
//		throw new IOException();
	}

	// MVC 모델에서는 예외처리를 적극적으로! => 예외 발생시 사용자에게 공지 => jsp로 분기(error 페이지)
//	@ExceptionHandler({SQLException.class, IOException.class})
//	public String handler(HttpServletRequest request, Model model) {
//		System.out.println("ExceptionHandler");
//		StringBuffer url = request.getRequestURL();
//		model.addAttribute("url", url);
//		return "error";
//	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handler() {
		Map<String, String> map = new HashMap<>();
		map.put("result", "ajax_exception");
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}
}

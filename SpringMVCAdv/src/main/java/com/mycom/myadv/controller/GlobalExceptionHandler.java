package com.mycom.myadv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 개별 Controller에서 처리하지 않은 모든 Exception을 이곳에서 처리
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURI());
		mav.setViewName("globalError");
		
		return mav;
	}
}

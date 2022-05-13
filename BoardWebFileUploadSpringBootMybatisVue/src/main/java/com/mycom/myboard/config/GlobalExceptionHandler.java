package com.mycom.myboard.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myboard.dto.BoardResultDto;

//@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("error");
//		return mav;
//	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<BoardResultDto> handleErrorResponseEntity() {
		System.out.println("!!!");
		BoardResultDto boardResultDto = new BoardResultDto();
		boardResultDto.setResult(-1);
		return new ResponseEntity<BoardResultDto>(boardResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

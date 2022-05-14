package com.mycom.myboard.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleErrorResponseEntity(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("ajax_global_exception", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

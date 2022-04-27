package com.mycom.myboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;
import com.mycom.myboard.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	private static final int SUCCESS = 1;

	@PostMapping(value="/register")
	public ResponseEntity<UserResultDto> register(UserDto dto, HttpSession session){
		
		UserResultDto userResultDto = userService.userRegister(dto);
		
		if( userResultDto.getResult() == SUCCESS ) {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.OK);
		}else {
			return new ResponseEntity<UserResultDto>(userResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

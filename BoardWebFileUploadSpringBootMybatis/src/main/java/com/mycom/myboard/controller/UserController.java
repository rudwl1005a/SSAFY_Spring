package com.mycom.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.UserDto;
import com.mycom.myboard.dto.UserResultDto;
import com.mycom.myboard.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	private static final int SUCCESS = 1;

	@PostMapping(value = "/register")
	public ResponseEntity<Map<String, String>> register(UserDto dto, HttpSession session) {

		UserResultDto userResultDto = userService.userRegister(dto);

		Map<String, String> map = new HashMap<>();
		if (userResultDto.getResult() == SUCCESS) {
			map.put("result", "success");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

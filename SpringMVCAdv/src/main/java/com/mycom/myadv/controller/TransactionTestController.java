package com.mycom.myadv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;
import com.mycom.myadv.service.StudentService;

@RestController
@RequestMapping("/tx")
public class TransactionTestController {

	@Autowired
	StudentService service;

	// 브라우저
	// JUnit test
	@PostMapping(value = "/students")
	public ResponseEntity<Integer> studentInsert(@RequestBody StudentDto studentDto) {
		System.out.println(studentDto);
		int ret = service.studentInsert(studentDto);
		return new ResponseEntity<Integer>(ret, HttpStatus.OK);
	}
}

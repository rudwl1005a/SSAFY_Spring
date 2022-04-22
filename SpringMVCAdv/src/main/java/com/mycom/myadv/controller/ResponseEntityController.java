package com.mycom.myadv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myadv.dto.StudentDto;

@RestController
@RequestMapping(value = "/re")
public class ResponseEntityController {

	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> list() {
		List<StudentDto> list = new ArrayList<>();
		list.add(new StudentDto(111, "홍길동", "hong@gildong.com", "010-0000-0000"));
		list.add(new StudentDto(222, "이길동", "lee@gildong.com", "010-1111-1111"));
		list.add(new StudentDto(333, "삼길동", "sam@gildong.com", "010-2222-2222"));
		return ResponseEntity.ok().body(list); // 200 OK
//		return ResponseEntity.badRequest().body(list); // 400 bad request
	}

	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> detail(@PathVariable int studentId) {
		StudentDto dto = new StudentDto(222, "이길동", "lee@gildong.com", "010-1111-1111");
		return new ResponseEntity<StudentDto>(dto, HttpStatus.OK); // 200 OK
//		return new ResponseEntity<StudentDto>(dto, HttpStatus.NOT_FOUND); // 404 Not Found
//		return new ResponseEntity<StudentDto>(dto, HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	}
}

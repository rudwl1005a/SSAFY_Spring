package com.mycom.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.rest.dto.StudentDto;

@RestController
@RequestMapping(value="/api/v2")
public class StudentController {

	// 목록 : GET students
	@GetMapping(value = "/students") // url mapping <= REST
	// @ResponseBody // json response -> @RestController를 사용하면 생략가능
	public List<StudentDto> list() {
		System.out.println("/students");
		List<StudentDto> list = new ArrayList<>();
		list.add(new StudentDto(11, "홍길동", "hong@gil.com", "010-1111-1111"));
		list.add(new StudentDto(22, "이길동", "lee@gil.com", "010-2222-2222"));
		list.add(new StudentDto(33, "삼길동", "sam@gil.com", "010-3333-3333"));
		return list;
	}
	
	// 상세 : GET students/123
	@GetMapping(value = "/students/{studentId}") // url mapping <= REST
	public StudentDto detail(@PathVariable int studentId) {
		System.out.println("/students/" + studentId);
		return new StudentDto(11, "홍길동", "hong@gil.com", "010-1111-1111");
	}
	
	// 등록 : POST students
	@PostMapping(value = "/students") // url mapping <= REST
	public int insert(StudentDto dto) {
		System.out.println(dto);
		return 1;
	}
	
	// 수정 : PUT students
	@PutMapping(value = "/students/{studentId}") // url mapping <= REST
	public int update(@PathVariable int studentId, @RequestBody StudentDto dto) {
		System.out.println("/students/" + studentId);
		System.out.println(dto);
		return 1;
	}
	
	// 삭제 : DELETE students/123
	@DeleteMapping(value = "/students/{studentId}") // url mapping <= REST
	public int update(@PathVariable int studentId) {
		System.out.println("/students/" + studentId);
		return 1;
	}
}

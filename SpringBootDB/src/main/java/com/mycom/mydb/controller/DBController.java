package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.DBService;

@RestController
public class DBController {

	@Autowired
	DBService service;

	// 객체 상세정보
	@GetMapping(value = "/empDetail/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println("employeeId : " + employeeId);
		EmpDto dto = service.empDetail(employeeId);
		System.out.println(dto);
		return dto;
	}

	// 객체 리스트 상세정보
	@GetMapping(value = "/empList")
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}

	// 객체 삽입,등록
	@PostMapping(value = "/empInsert")
	public int empInsert(EmpDto dto) {
		System.out.println(dto);
		return service.empInsert(dto);
	}
	
	// JSON객체 삽입,등록
	@PostMapping(value = "/empInsertJSON")
	public int empInsertJSON(@RequestBody EmpDto dto) { // @RequestBody : JSON객체를 받기 위한 어노테이션
		System.out.println(dto);
		return service.empInsert(dto);
	}
	
	// 객체 수정
	@PostMapping(value = "/empUpdate")
	public int empUpdate(EmpDto dto) {
		System.out.println(dto);
		return service.empUpdate(dto);
	}
	
	// 객체 삭제
	@PostMapping(value = "/empDelete")
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		return service.empDelete(employeeId);
	}
	
}

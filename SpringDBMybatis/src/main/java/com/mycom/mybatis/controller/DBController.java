package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.DBService;

@Controller
public class DBController {

	@Autowired
	DBService service;

	// 객체 상세정보
	@GetMapping(value = "/empDetail/{employeeId}")
	@ResponseBody
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println("employeeId : " + employeeId);
		EmpDto dto = service.empDetail(employeeId);
		System.out.println(dto);
		return dto;
	}
	
	// 객체 상세정보 페이지 이동
	@GetMapping(value = "/empDetailPage/{employeeId}")
	public String empDetailPage(@PathVariable int employeeId, Model model) {
		System.out.println("employeeId : " + employeeId);
		EmpDto dto = service.empDetail(employeeId);
		System.out.println(dto);
		
		model.addAttribute("dto", dto);
		return "detail"; // jsp로 이동
	}

	// 객체 리스트 상세정보
	@GetMapping(value = "/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}

	// 객체 삽입,등록
	@PostMapping(value = "/empInsert")
	@ResponseBody
	public int empInsert(EmpDto dto) {
		System.out.println(dto);
		return service.empInsert(dto);
	}
	
	// JSON객체 삽입,등록
	@PostMapping(value = "/empInsertJSON")
	@ResponseBody
	public int empInsertJSON(@RequestBody EmpDto dto) { // @RequestBody : JSON객체를 받기 위한 어노테이션
		System.out.println(dto);
		return service.empInsert(dto);
	}
	
	// 객체 수정
	@PostMapping(value = "/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto dto) {
		System.out.println(dto);
		return service.empUpdate(dto);
	}
	
	// 객체 삭제
	@PostMapping(value = "/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		return service.empDelete(employeeId);
	}
	
}

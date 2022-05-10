package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mybatis.dto.StudentDto;
import com.mycom.mybatis.service.StudentService;

@RestController
@RequestMapping(value = "/vue")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentVueController {

	@Autowired
	StudentService service;

	// 목록
	@GetMapping(value = "/students")
	public ResponseEntity<List<StudentDto>> list() {
		List<StudentDto> list = service.list();
		if (list.size() > 0) {
			return new ResponseEntity<List<StudentDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<StudentDto>>(list, HttpStatus.NOT_FOUND);
		}
	}

	// 상세
	@GetMapping(value = "/students/{studentId}")
	public ResponseEntity<StudentDto> detail(@PathVariable int studentId) {
		StudentDto dto = service.detail(studentId);
		if (dto != null) {
			return new ResponseEntity<StudentDto>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<StudentDto>(dto, HttpStatus.NOT_FOUND);
		}
	}

	// 등록
	@PostMapping(value = "/students")
	public ResponseEntity<Integer> insert(@RequestBody StudentDto dto) {
		int n = service.insert(dto);
		if (n == 1) {
			return new ResponseEntity<Integer>(n, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(n, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 수정 => boot에서는 parameter로 json이 아닌 객체 가능 -> @ResponseBody 필요 없음
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<Integer> update(@PathVariable int studentId, @RequestBody StudentDto dto) {
		int n = service.update(dto);
		if (n == 1) {
			return new ResponseEntity<Integer>(n, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(n, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// 삭제
	@DeleteMapping(value = "/students/{studentId}")
	public ResponseEntity<Integer> delete(@PathVariable int studentId) {
		int n = service.delete(studentId);
		if (n == 1) {
			return new ResponseEntity<Integer>(n, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(n, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

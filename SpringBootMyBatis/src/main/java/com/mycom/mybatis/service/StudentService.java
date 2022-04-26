package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.StudentDto;

public interface StudentService {
	List<StudentDto> list(); // 목록
	StudentDto detail(int studentId); // 상세
	int insert(StudentDto dto); // 등록
	int update(StudentDto dto); // 수정
	int delete(int studentId); // 삭제
}

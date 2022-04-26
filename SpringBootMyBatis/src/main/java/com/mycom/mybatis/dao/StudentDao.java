package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.StudentDto;

@Mapper
public interface StudentDao {
	List<StudentDto> list(); // 목록
	StudentDto detail(int studentId); // 상세
	int insert(StudentDto dto); // 등록
	int update(StudentDto dto); // 수정
	int delete(int studentId); // 삭제
}

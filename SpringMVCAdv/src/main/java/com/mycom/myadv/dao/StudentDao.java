package com.mycom.myadv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myadv.dto.StudentDto;

@Mapper
public interface StudentDao {
	public int studentInsert(StudentDto dto);
	public StudentDto studentDetail(int studentId);
}

package com.mycom.myadv.service;

import com.mycom.myadv.dto.StudentDto;

public interface StudentService {
	public int studentInsert(StudentDto dto);
	public StudentDto studentDetail(int studentId);
}

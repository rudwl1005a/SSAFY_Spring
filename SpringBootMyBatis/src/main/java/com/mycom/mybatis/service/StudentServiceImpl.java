package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.StudentDao;
import com.mycom.mybatis.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public List<StudentDto> list() {
		return dao.list();
	}

	@Override
	public StudentDto detail(int studentId) {
		return dao.detail(studentId);
	}

	@Override
	public int insert(StudentDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(StudentDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		return dao.delete(studentId);
	}
}

package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

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
	@Transactional
	public int insert(StudentDto dto) {
		dao.insert(dto);
		{ // 예외를 발생시키는 코드 - for transaction test
			String str = null;
			str.length();
		}
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

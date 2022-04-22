package com.mycom.myadv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.myadv.dao.StudentDao;
import com.mycom.myadv.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;
	
	@Override
	@Transactional
	public int studentInsert(StudentDto dto) {
		// 트랜잭션
		dao.studentInsert(dto);
		String s = null;
		s.length(); // 오류!
		return dao.studentInsert(dto); // 실행 안됨
	}

	@Override
	public StudentDto studentDetail(int studentId) {
		return dao.studentDetail(studentId);
	}

}

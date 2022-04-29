package com.mycom.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.jpa.dao.StudentDao;
import com.mycom.jpa.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao dao;

	@Override
	public List<Student> list() {
		return dao.findAll();
	}

	@Override
	public Optional<Student> detail(int studentId) { // null체크
		return dao.findById(studentId);
	}

	@Override
	public Student insert(Student student) {
		return dao.save(student);
	}

	@Override
	public Student update(Student student) {
		return dao.save(student);
	}

	@Override
	public void delete(int studentId) {
		dao.deleteById(studentId);
	}
}

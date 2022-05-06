package com.mycom.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public List<Student> list(int limit, int offset) {
		System.out.println("limit : " + limit);
		System.out.println("offset : " + offset);
		Pageable pageable = PageRequest.of(offset / limit, limit); // page (offset 이 아님), size
		Page<Student> page = dao.findAll(pageable);
		return page.toList();
	}

	@Override
	public List<Student> findByStudentNm(String studentNm) {
		return dao.findByStudentNm(studentNm);
	}

	@Override
	public List<Student> findByEmailAndPhone(String email, String phone) {
		return dao.findByEmailAndPhone(email, phone);
	}

	@Override
	public List<Student> findByEmailOrPhone(String email, String phone) {
		return dao.findByEmailOrPhone(email, phone);
	}

	@Override
	public List<Student> findByStudentNmLike(String studentNm) {
		// == IsContaining == Containing no need %
//	    return dao.findByStudentNmContains(studentNm);

		// need % - 직접 제어
		return dao.findByStudentNmLike("%" + studentNm + "%");
//	    return dao.findByStudentNmLike("%"+studentNm);
//	    return dao.findByStudentNmStartsWith(studentNm);
//	    return dao.findByStudentNmEndsWith(studentNm);
	}

	@Override
	public List<Student> findByStudentIdBetween(int from, int to) {
		return dao.findByStudentIdBetween(from, to);
	}

	@Override
	public List<Student> findByStudentIdBetweenOrderByStudentNmDesc(int from, int to) {
		return dao.findByStudentIdBetweenOrderByStudentNmDesc(from, to);
	}
	
}

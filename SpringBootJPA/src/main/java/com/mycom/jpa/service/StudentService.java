package com.mycom.jpa.service;

import java.util.List;
import java.util.Optional;

import com.mycom.jpa.entity.Student;

public interface StudentService {
	List<Student> list(); // 목록
	Optional<Student> detail(int studentId); // 상세
	Student insert(Student student); // 등록
	Student update(Student student); // 수정
	void delete(int studentId); // 삭제
	
	long count();
	List<Student> list(int limit, int offset);
	
	List<Student> findByStudentNm(String studentNm);
	List<Student> findByEmailAndPhone(String email, String phone);
	List<Student> findByEmailOrPhone(String email, String phone);
	
	List<Student> findByStudentNmLike(String studentNm);
	
	List<Student> findByStudentIdBetween(int from, int to);
	
	List<Student> findByStudentIdBetweenOrderByStudentNmDesc(int from, int to);
}

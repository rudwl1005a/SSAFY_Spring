package com.mycom.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.jpa.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	// JpaRepository를 상속받는 interface는 굳이 별도의 동일한 기능을 가지는 메소드를 새로 정의할 필요가 없다
	// 이 상태에서 CURD가 가능하다
//	List<StudentDto> list(); // 목록
//	StudentDto detail(int studentId); // 상세
//	int insert(StudentDto dto); // 등록
//	int update(StudentDto dto); // 수정
//	int delete(int studentId); // 삭제
	
	List<Student> findByStudentNm(String studentNm);
	List<Student> findByEmailAndPhone(String email, String phone);
	List<Student> findByEmailOrPhone(String email, String phone);
	
	List<Student> findByStudentNmLike(String studentNm);
	
	List<Student> findByStudentIdBetween(int from, int to);
	
	List<Student> findByStudentIdBetweenOrderByStudentNmDesc(int from, int to); // Desc빼면 오름차순
}

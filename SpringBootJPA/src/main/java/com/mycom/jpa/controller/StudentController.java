package com.mycom.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.jpa.entity.Student;
import com.mycom.jpa.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	// 목록
	@GetMapping(value = "/students")
	public List<Student> list() {
		List<Student> list = service.list();
		for (Student Student : list) {
			System.out.println(Student);
		}
		return list;
	}

	// 상세
	@GetMapping(value = "/students/{studentId}")
	public Optional<Student> detail(@PathVariable int studentId) {
		System.out.println(studentId);
		return service.detail(studentId);
	}

	// 등록
	@PostMapping(value = "/students")
	public Student insert(Student dto) {
		System.out.println(dto);
		return service.insert(dto);
	}

	// 수정 => boot에서는 parameter로 json이 아닌 객체 가능 -> @ResponseBody 필요 없음
	@PutMapping(value = "/students/{studentId}")
	public Student update(@PathVariable int studentId, Student dto) {
		System.out.println(dto);
		System.out.println("studentId : " + studentId);
		return service.update(dto);
	}

	// 삭제
	@DeleteMapping(value = "/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		System.out.println(studentId);

		try {
			service.delete(studentId);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	@GetMapping("/students/count")
    public long countStudent() {
        return service.count();
    }
	
	@GetMapping("/students/page")
	public List<Student> listStudent(int limit, int offset) {
	    return service.list(limit, offset);
	}
	
	@GetMapping("/students/studentnm")
    public List<Student> findByStudentNm(String studentNm) {
        return service.findByStudentNm(studentNm);
    }
	
	@GetMapping("/students/emailandphone")
    public List<Student> findByEmailAndPhone(String email, String phone) {
        return service.findByEmailAndPhone(email, phone);
    }
	
	@GetMapping("/students/emailorphone")
	public List<Student> findByEmailOrPhone(String email, String phone) {
		return service.findByEmailOrPhone(email, phone);
	}
	
	@GetMapping("/students/studentnmlike")
	public List<Student> findByStudentByStudentNmLike(String studentNm) {
	    return service.findByStudentNmLike(studentNm);
	}
	
	@GetMapping("/students/studentidbetween")
    public List<Student> findByStudentIdBetween(int from, int to) {
        return service.findByStudentIdBetween(from, to);
    }
	
	@GetMapping("/students/studentidbetweenorderby")
    public List<Student> findByStudentIdBetweenOrderByStudentNmDesc(int from, int to) {
        return service.findByStudentIdBetweenOrderByStudentNmDesc(from, to);
    }
}

package com.mycom.myadv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.myadv.dto.StudentDto;
import com.mycom.myadv.service.StudentService;

@RunWith(SpringRunner.class) // junit과 spring연결
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml") // Spring context 설정
public class StudentTest {
	
	@Autowired
	StudentService service;
	
	@Test
	public void testBeanCreation() {
		assertNotNull(service);
	}
	
//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testStudentInsert() {
//		StudentDto dto = new StudentDto();
//		dto.setStudentNm("홍길동");
//		dto.setEmail("lee@gildong.com");
//		dto.setPhone("010-5555-5555");
//		assertEquals(service.studentInsert(dto), 1);
//	}
	
	@Test
	public void testStudentDetail() {
		// '1', '삼길동', 'sam@hong.com', '010-2222-2222'
		StudentDto dto = new StudentDto();
		dto.setStudentId(1);
		dto.setStudentNm("삼길동");
		dto.setEmail("sam@hong.com");
		dto.setPhone("010-2222-2222");
		
		assertEquals(service.studentDetail(1), dto);
	}
}

package com.mycom.more;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@SpringBootTest
class SpringBootMoreApplicationTests {

	@Autowired
	StudentService service;

	@Test
	void testService() {
		assertNotNull(service);
	}

	@Test
	void testInsert() {
		StudentDto dto = new StudentDto();
		dto.setStudentNm("박길동");
		dto.setEmail("park@gildong.com");
		dto.setPhone("010-2345-2345");
		assertEquals(1, service.insert(dto));
	}

}

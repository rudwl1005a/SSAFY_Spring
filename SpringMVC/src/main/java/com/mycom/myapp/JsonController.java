package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {
	
	@PostMapping(value="/emp")
	public void m1(@RequestBody EmpDto dto) {
		System.out.println(dto);
	}
	
}

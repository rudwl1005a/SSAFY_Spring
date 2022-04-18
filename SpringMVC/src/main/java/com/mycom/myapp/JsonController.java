package com.mycom.myapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class JsonController {

	@PostMapping(value = "/emp")
	public void m1(@RequestBody EmpDto dto) {
		System.out.println(dto);
	}

	@PostMapping(value = "/empList")
	public void m2(@RequestBody List<EmpDto> empList) {
		for (EmpDto empDto : empList) {
			System.out.println(empDto);
		}
	}

	@GetMapping(value = "/empDetail/{employeeId}")
	@ResponseBody // json으로 보내라
	public EmpDto m3(@PathVariable int employeeId) {
		System.out.println("employeeId : " + employeeId);
		EmpDto dto = new EmpDto(2000, "길동", "유", "gildong5@yu.com", "2000-04-08");
		// json으로 dto를 내려보내야 함
		return dto; // dto를 json으로 response로 보내달라 -> @ResponseBody
	}

	@GetMapping(value = "/empList")
	@ResponseBody
	public List<EmpDto> m4() {
		List<EmpDto> list = new ArrayList<>();
		list.add(new EmpDto(2000, "길동", "유", "gildong5@yu.com", "2000-04-08"));
		list.add(new EmpDto(2010, "길동", "차", "gildong6@cha.com", "2000-04-09"));
		list.add(new EmpDto(2020, "길동", "서", "gildong7@seo.com", "2000-04-10"));

		return list;
	}

	// 날짜 시간 <= LocalDateTime
	@GetMapping(value="/LocalDateTime")
	@ResponseBody
	public LocalDateTime m5() {
		return LocalDateTime.now();
	}
}

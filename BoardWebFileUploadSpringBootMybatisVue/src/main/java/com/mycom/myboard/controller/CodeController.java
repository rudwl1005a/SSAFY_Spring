package com.mycom.myboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.dto.CodeDto;
import com.mycom.myboard.service.CodeService;

@RestController
@CrossOrigin(
    // localhost:5500 과 127.0.0.1 구분
    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
    allowCredentials = "true", 
    allowedHeaders = "*", 
    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class CodeController {

	@Autowired
	CodeService codeService;

	@GetMapping (value="/codes")
	public ResponseEntity<List<CodeDto>> codeList(String groupCode){
		List<CodeDto> list = codeService.codeList(groupCode);
		if(list != null) {
			return new ResponseEntity<List<CodeDto>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<CodeDto>>(list, HttpStatus.NOT_FOUND);
		}
	}
}

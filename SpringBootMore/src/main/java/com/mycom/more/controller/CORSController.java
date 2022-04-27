package com.mycom.more.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(
//	origins = "http://127.0.0.1:5500/", // 개발 서버 환경
//	allowCredentials = "true",
//	allowedHeaders = "*",
//	methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD, RequestMethod.OPTIONS }
//)
@RestController
public class CORSController {

	@GetMapping("/getcors")
	public ResponseEntity<String> getCORS() {
		return new ResponseEntity<String>("getcors", HttpStatus.OK);
	}

	@PostMapping("/postcors")
	public ResponseEntity<String> postCORS() {
		return new ResponseEntity<String>("postcors", HttpStatus.OK);
	}

	@PutMapping("/putcors")
	public ResponseEntity<String> putCORS() {
		return new ResponseEntity<String>("putcors", HttpStatus.OK);
	}
}

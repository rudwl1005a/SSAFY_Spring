package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 기존 서블릿과 다른 점
 * 1. 기존 서블릿은 맨 앞 / 빼면 오류 - tomcat start X
 * 2. 서브 도메인의 처리가 다르다. servlet은 /* 만하면 하위 전부, spring은 /*, /** 구분해서 사용한다
 *    서블릿에 /** 을 사용하면 문자로 간주한다(url이 /**인것)
 */
@Controller
@RequestMapping(value="/insa") // controller에다가 urlmapping을 해주면 밑의 mapping은 자동으로 포함됨 (ex. m1메서드를 실행시키려면 /insa/hello로 들어가야함)
public class UrlMappingController {
	
	@RequestMapping(value="/hello") // method 방식과 상관없이 모두 처리
	public void m1() {
		System.out.println("/hello");
	}
	
	@RequestMapping(value="/hello/ssafy")
	public void m2() {
		System.out.println("/hello/ssafy");
	}
	
	@RequestMapping(value={"/url1", "/url2"})
	public void m3() {
		System.out.println("/url1 /url2");
	}
	
	// select 목록조회, 상세조회
	@RequestMapping(value="/method", method=RequestMethod.GET) // get 방식의 요청만 받음
	public void m4() {
		System.out.println("/get");
	}
	
	// insert 등록
	@RequestMapping(value="/method", method=RequestMethod.POST) // post 방식의 요청만 받음
	public void m5() {
		System.out.println("/post");
	}
	
	// update 수정
	@RequestMapping(value="/method/{num}", method=RequestMethod.PUT) // put 방식의 요청만 받음
	public void m6(@PathVariable int num) {
		System.out.println("/put");
		System.out.println(num);
	}
	
	@RequestMapping(value="/method/{num}/and/{str}", method=RequestMethod.PUT) // parameter 2개 이상 - url은 아무렇게나 가능	
	public void m7(@PathVariable int num, @PathVariable String str) {
		System.out.println("/put");
		System.out.println(num);
		System.out.println(str);
	}
	
	// delete 삭제
	@RequestMapping(value = "/method/{num}", method = RequestMethod.DELETE) // delete 방식의 요청만 받음
	public void m8(@PathVariable int num) {
		System.out.println("/delete");
		System.out.println(num);
	}
	
	// 위의 내용을 어노테이션으로 간결하게	
	@GetMapping(value = "/getmapping") // get 방식의 요청만 받음
	public void m9() {
		System.out.println("/getmapping");
	}
	
	@PostMapping(value = "/postmapping") // post 방식의 요청만 받음
	public void m10() {
		System.out.println("/postmapping");
	}
	
	// suburl
	@GetMapping(value = "/subtest/*") // 바로 다음 하위만 처리
	public void m11() {
		System.out.println("/subtest/*");
	}
	
	@GetMapping(value = "/subtest/**") // 전체 하위 경로 처리, 하위 경로가 없을때도 여기서 처리
	public void m12() {
		System.out.println("/subtest/**");
	}
}

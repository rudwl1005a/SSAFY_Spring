package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {
	
	@GetMapping(value="/param1")
	public void m1(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		System.out.println("/param1 seq : " + seq);
	}
	
	@GetMapping(value="/param2")
	public void m2(String seq) { // 매칭 안되면 null처리
		System.out.println("/param2 seq : " + seq);
	}
	
	@GetMapping(value="/param3")
	public void m3(@RequestParam(name="seq", required=false) String seq) { // @RequestParam : 일치하지 않을때는 서버에서 warning, required default:true / false면 매칭 안되면 null
		System.out.println("/param3 seq : " + seq);
	}
	
	@GetMapping(value="/car1")
	public void m4(String name, int price) { // int는 primitive type이라서 명시해 주지 않을 때 null로 처리가 안된다 -> 0으로도 안됨(오류) / name은 명시해 주지 않으면 null로 처리
		System.out.println("name : " + name);
		System.out.println("price : " + price);
	}
	
	@GetMapping(value="/car2")
	public void m5(CarDto dto) { // DTO에서의 primitive type은 명시해 주지 않으면 0으로 처리 -> m4처럼 풀어서 쓰지 말고 DTO로 사용하는 것이 더 낫다
		// DTO에 접근할 때는 setter getter로 접근하기 때문에 DTO에서의 멤버변수가 name2라고 하더라도 파라미터를 name으로 접근해야 한다(setName, getName일떄)
		System.out.println(dto);
	}
	
	@GetMapping(value="/map")
	public void m6(@RequestParam Map<String, String> map) { // Map은 @RequestParam이 필요하다
		System.out.println(map.get("name"));
		System.out.println(map.get("price"));
		System.out.println(map.get("owner"));
	}
	
	// 헤더 정보 읽어오기
	@GetMapping(value="/header")
	public void m7(@RequestHeader(value="Accept") String accept, @RequestHeader(value="Host") String host) {
		System.out.println(accept);
		System.out.println(host);
	}
	
	@GetMapping(value="/session")
	public String m8(String msg, HttpSession session) {
		System.out.println(msg);
		session.setAttribute("msg", msg);
		return "sessionTest"; // prefix -> (WEB-INF/views/)sessionTest(.jsp) <- suffix
	}
	
}

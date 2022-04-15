package com.mycom.myapp.calc.annotation;

import org.springframework.stereotype.Component;

@Component("componentName") // 이름 생략하면 class의 맨 앞 대문자를 소문자로 바꾼 이름으로 자동 생성 (여기서는 calculator)
public class Calculator {
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}

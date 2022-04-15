package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		// Spring - Configuration 어노테이션 사용
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		Calculator calc = (Calculator) context.getBean("calculator");
		
		int n = calc.add(7, 5);
		System.out.println(n);
		
		context.close();
	}
	
}

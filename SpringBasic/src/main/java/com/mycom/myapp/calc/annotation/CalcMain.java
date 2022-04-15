package com.mycom.myapp.calc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		// Spring - annotation사용
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-annotation.xml");
		Calculator calc = (Calculator) context.getBean("componentName");
		
		int n = calc.add(7, 4);
		System.out.println(n);
		
		context.close();
	}
	
}

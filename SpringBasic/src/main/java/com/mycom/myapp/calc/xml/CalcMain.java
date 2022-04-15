package com.mycom.myapp.calc.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		// Spring X
//		Calculator calc = new Calculator();
//		int n = calc.add(7, 3);
//		System.out.println(n);
		
		// Spring - xml사용
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		Calculator calc = (Calculator) context.getBean("calculator");
		
		int n = calc.add(7, 3);
		System.out.println(n);
		
		context.close();
	}
	
}

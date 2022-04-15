package com.mycom.myapp.calc.hasa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("use-calc-annotation.xml");
		UseCalculator useCalc = (UseCalculator) context.getBean("useCalculator");
		
		int n = useCalc.add(7, 6);
		System.out.println(n);
		
		context.close();
	}
	
}

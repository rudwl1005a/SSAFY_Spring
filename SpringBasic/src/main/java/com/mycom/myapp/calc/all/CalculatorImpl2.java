package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("Impl2")
public class CalculatorImpl2 implements Calculator {
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl2 : add()");
		return n1 + n2;
	}
}

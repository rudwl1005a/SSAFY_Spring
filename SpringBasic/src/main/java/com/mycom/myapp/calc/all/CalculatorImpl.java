package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("Impl")
public class CalculatorImpl implements Calculator {
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl : add()");
		return n1 + n2;
	}
}

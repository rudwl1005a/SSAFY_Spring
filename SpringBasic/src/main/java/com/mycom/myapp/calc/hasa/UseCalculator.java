package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {
	
	@Autowired
	Calculator calculator;
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}

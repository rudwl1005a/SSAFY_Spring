package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UseCalculator {
	
	@Autowired // 인터페이스(Calculator)에 @Component가 붙는게 아니고 구현클래스(CalculatorImpl)에 붙어야 한다 
	@Qualifier("Impl") // 매칭되는 구현클래스가 2개 이상일 때 @Component의 이름으로 명확하게 해준다
	Calculator calculator; // interface type 
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
}

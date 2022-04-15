package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalcConfiguration {
	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}

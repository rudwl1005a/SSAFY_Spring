package com.mycom.myapp.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {
	public void bp() {
		System.out.println("BusinessProcess : bp()");
	}
	
	public String bp2(int i, String str, int i2) {
		System.out.println("BusinessProcess : bp2()");
		return "";
	}
}

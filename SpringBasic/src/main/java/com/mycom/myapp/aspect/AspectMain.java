package com.mycom.myapp.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect.xml");
		
		BusinessProcess bp = (BusinessProcess) context.getBean("businessProcess");
		bp.bp();
		System.out.println("----------------------------");
		bp.bp2(1, "str", 2);
		
		context.close();
	}

}

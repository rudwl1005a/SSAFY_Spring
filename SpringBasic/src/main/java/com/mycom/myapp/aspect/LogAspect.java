package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 모든 리턴 타입, com.mycom.myapp.aspect.모든 클래스.모든메서드(모든 파라미터)
	@Pointcut(value="execution(* com.mycom.myapp.aspect.*.*(..))") // value="execution(리턴 타입  패키지.클래스명.메서드명(파라미터 타입))"
	private void logPointcut() {}
	
//	@Before("logPointcut()") // @Before : 파라미터에 명시된 메서드 이전에 실행
	@After("logPointcut()") // @After : 파라미터에 명시된 메서드 이후에 실행
	public void beforeLog(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("메소드 이름 : " + signature.getName()); // logger이용X 단순출력
		logger.debug("[Logger Before] " + signature.getName()); // logger이용
	}
	
	
	@Pointcut(value="execution(String com.mycom.myapp.aspect.*.*(int, String, int))")
	private void logPointcut2() {}
	
	@After("logPointcut2()")
	public void beforeLog2(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		System.out.println("메소드 이름2 : " + signature.getName());
		logger.debug("[Logger Before2] " + signature.getName());
	}
}

package org.zerock.aop;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	
	// 실행 전 후에 처리를 선언해서 동작 시키는 것을 의미 : @Around
	@Around("execution(* org.zerock.*.service.*ServiceImpl.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		// 실행되는 클래스
		log.info("*  Target(실행객체): " + pjp.getTarget());
		log.info("*  실행 메서드 : "+pjp.getSignature());
		
		// 넘어가는 데이터
		log.info("*  Param(전달되는 데이터): " + Arrays.toString(pjp.getArgs()));

		// 처리하는 내용
		Object result = null;

		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("*  result(처리결과): " + result);
		long end = System.currentTimeMillis();
		
		log.info("*  TIME: " + (end - start));
		
		return result;
	}
}

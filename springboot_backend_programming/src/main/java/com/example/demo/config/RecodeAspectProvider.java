package com.example.demo.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class RecodeAspectProvider {
	
	@Around("@annotation(com.example.demo.config.PerformanceTimeRecord)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();	// 시작시간
		
		Object proceed = joinPoint.proceed();	// 실제 메소드의 내부 로직을 수행
		
		long executionTime = System.currentTimeMillis() - start;	// 종료시간
		
		log.info(joinPoint.getSignature() + "executed in " + executionTime + "ms");	// log
		
		return proceed;	// proceed() 결과 반환
	}
}

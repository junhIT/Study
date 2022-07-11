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
		
		long start = System.currentTimeMillis();	// ���۽ð�
		
		Object proceed = joinPoint.proceed();	// ���� �޼ҵ��� ���� ������ ����
		
		long executionTime = System.currentTimeMillis() - start;	// ����ð�
		
		log.info(joinPoint.getSignature() + "executed in " + executionTime + "ms");	// log
		
		return proceed;	// proceed() ��� ��ȯ
	}
}

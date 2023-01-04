package com.example.springbase.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class PerfAspect {

	@Around("execution(* com.example.springbase.controller..*.*(..))")
	public Object logAspect(ProceedingJoinPoint pjp) throws Throwable {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");	
		
		String nowDtm = sdf.format(new Date());
		
		Object returnVal = pjp.proceed();
		
		log.debug("===================================================================");
		log.debug(nowDtm + "currentProceed = ", pjp.getSignature());
		log.debug("===================================================================");
		
		return returnVal;
	}
}

package com.learn.usermanagement.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ExceptionAspect {

	@AfterThrowing(pointcut = "execution(* com.learn.usermanagement..*(..))", throwing = "ex")
	public void logException(Exception ex) {
		log.error("Unhandled exception occurred: {}", ex.getMessage(), ex);
	}
}

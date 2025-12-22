package com.learn.usermanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

	@Before("execution(* com.learn.usermanagement.service.*.*(..))")
	public void validateInputs(JoinPoint joinPoint) {
		for (Object arg : joinPoint.getArgs()) {
			if (arg == null) {
				throw new IllegalArgumentException("Null arguments are not allowed");
			}
		}
	}
}

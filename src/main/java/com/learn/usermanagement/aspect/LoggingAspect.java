package com.learn.usermanagement.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Around("execution(* com.learn.usermanagement.service.*.*(..))")
	public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();
		log.info("Entering method: {}", joinPoint.getSignature());

		Object result = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - start;
		log.info("Exiting method: {} | Execution time: {} ms", joinPoint.getSignature(), timeTaken);

		return result;
	}
}

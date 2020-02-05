package com.anant.mv.hibernate.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

	//setup logger
	private Logger myLogger=Logger.getLogger(CRMLoggingAspect.class.getName());
	
	
	//add pointcut expression
	
	@Pointcut("execution(* com.anant.mv.hibernate.controller.*.*(..))")
	private void controllerLogger() {}
	
	//add pointcut for service and dao
	@Pointcut("execution(* com.anant.mv.hibernate.dao.*.*(..))")
	private void daoLogger() {}
	
	@Pointcut("execution(* com.anant.mv.hibernate.service.*.*(..))")
	private void serviceLogger() {}
	
	//add all the pointcut together
	
	@Pointcut("controllerLogger() || daoLogger() || serviceLogger()")
	private void applicationFlow() {			}
	
	
	//add @Before advise
	
	@Before("applicationFlow()")
	public void beforeAdvise(JoinPoint theJoinPoint) {
		
		String mSig=theJoinPoint.getSignature().toShortString();
		myLogger.info(">>>>>>>>>>:: "+mSig);
		
		//get the arguments
		
		Object[] argument=theJoinPoint.getArgs();
		for (Object args : argument) {
			myLogger.info(">>>>>>>>>>Arguments:: "+args);
			
		}
	}
	
	//add @after returning advise
	
	@AfterReturning(pointcut = "applicationFlow()",returning = "theResult")
	public void afterReturningAdvise(JoinPoint theJoinPoint,Object theResult) {
		
		//display method we are returning from
		String mSignature=theJoinPoint.getSignature().toShortString();
		
		myLogger.info(">>>>>>>>>>>Signature we are returning from:: "+mSignature);
		
		//display data returned
		
		myLogger.info(">>>>>>>>>>>>Result after returning from advise:: "+theResult);
		
		
	}
	
	
}

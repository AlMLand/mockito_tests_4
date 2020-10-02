package com.morlandalex.maven_spring_mockito_23_transfer.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(* *.transferMoney(..))")
	public void logBeforeMethodTransferMoney() {
		System.out.println("#### before transferring the money -> call LoggingAspect.logBeforeMethodTransferMoney() ####");
	}
	
	@Before("execution(* *.transfer(..))")
	public void logBeforeMethodTransfer() {
		System.out.println("#### before transferring the money -> call LoggingAspect.logBeforeMethodTransfer() ####");
	}
	
	@After("execution(* *.transfer(..))")
	public void logAfterMethodTransfer() {
		System.out.println("#### after transferring the money -> call LoggingAspect.logAfterMethodTransfer() ####");
	}
	
	@After("execution(* *.transferMoney(..))")
	public void logAfterMethodTransferMoney() {
		System.out.println("#### after transferring the money -> call LoggingAspect.logAfterMethodTransferMoney() ####");
	}
	
}

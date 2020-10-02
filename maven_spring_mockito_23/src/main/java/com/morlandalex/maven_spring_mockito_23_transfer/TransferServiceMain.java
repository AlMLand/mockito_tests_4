package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransferServiceMain {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TransferMoney transferService = (TransferMoney) appContext.getBean("transferMoneyService");
		transferService.transferMoney(1L, 2L, new BigDecimal(2000.00));
		
		appContext.close();

	}

}

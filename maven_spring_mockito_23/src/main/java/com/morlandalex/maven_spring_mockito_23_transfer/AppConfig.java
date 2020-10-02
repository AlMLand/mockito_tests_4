package com.morlandalex.maven_spring_mockito_23_transfer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.morlandalex.maven_spring_mockito_23_transfer.aspects.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	public TransferMoney transferMoneyService() {
		return new TransferMoneyService(getAccountJdbcRepository(), transferJdbcRepository());
	}

	@Bean
	public TransferRepository transferJdbcRepository() {
		return new TransferJdbcRepository();
	}

	@Bean
	public AccountRepository getAccountJdbcRepository() {
		return new GetAccountJdbcRepository();
	}

	@Bean
	public LoggingAspect loggingAspectForMethodTransfer() {
		return new LoggingAspect();
	}

}

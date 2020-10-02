package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;

public class TransferJdbcRepository implements TransferRepository {

	@Override
	public boolean transfer(Long idAccount_1, Long idAccount_2, BigDecimal amount) {
		
		return false;
	}

}

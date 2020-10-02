package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;

public interface TransferRepository {

	public abstract boolean transfer(Long idAccount_1, Long idAccount_2, BigDecimal amount);

}

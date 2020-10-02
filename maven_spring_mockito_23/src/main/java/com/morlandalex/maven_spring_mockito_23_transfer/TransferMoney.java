package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;

public interface TransferMoney {

	public abstract void transferMoney(Long idAccount_1, Long idAccount_2, BigDecimal amount);

}

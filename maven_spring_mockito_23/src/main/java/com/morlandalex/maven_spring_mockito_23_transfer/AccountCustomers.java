package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigInteger;

public class AccountCustomers extends Account {
	
	public AccountCustomers() {
		
	}

	public AccountCustomers(Long id, String firstName, String lastName, String adress, BigInteger bankCardNumber) {
		super(id, firstName, lastName, adress, bankCardNumber);
	}

}

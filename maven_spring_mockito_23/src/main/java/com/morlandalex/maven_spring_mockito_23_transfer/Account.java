package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class Account {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String adress;
	private BigInteger bankCardNumber;
	private BigDecimal bankBalance;
	private String transferAmount;

	public Account() {
		
	}
	
	public Account(Long id, String firstName, String lastName, String adress, BigInteger bankCardNumber) {
		super();
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAdress(adress);
		setBankCardNumber(bankCardNumber);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public BigInteger getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(BigInteger bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(String transferAmount) {
		this.transferAmount = transferAmount;
	}

	public BigDecimal getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(BigDecimal bankBalance) {
		this.bankBalance = bankBalance;
	}

}

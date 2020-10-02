package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;

public class TransferMoneyService implements TransferMoney {

	private AccountRepository accountRepository;
	private TransferRepository transferRepository;

	public TransferMoneyService(AccountRepository accountRepository, TransferRepository transferRepository) {
		setAccountRepository(accountRepository);
		setTransferRepository(transferRepository);
	}

	@Override
	public void transferMoney(Long idAccount_1, Long idAccount_2, BigDecimal amount) {
		transferRepository.transfer(idAccount_1, idAccount_2, amount);
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public TransferRepository getTransferRepository() {
		return transferRepository;
	}

	public void setTransferRepository(TransferRepository transferRepository) {
		this.transferRepository = transferRepository;
	}

}

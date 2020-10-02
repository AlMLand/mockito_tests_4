package com.morlandalex.maven_spring_mockito_23_transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TransferMoneyServiceTest_2 {

	/*
	// InjectMocks durch den constructor
	@Mock(name = "accountRepository")
	private AccountRepository accountRepository;
	@Mock(name = "transferRepository")
	private TransferRepository transferRepository;
	@InjectMocks
	private TransferServiceImpl transferServiceImpl;
	
	// InjectMocks Spy Objecte 
	private TransferServiceImpl transferServiceImplSpy = spy(new TransferServiceImpl(accountRepository, transferRepository));
	*/
	
	// odnostrochnie zagluschki
	private TransferRepository transferRepositoryTrue = when(mock(TransferRepository.class).transfer(anyLong(), anyLong(), any())).thenReturn(true).getMock();
	private TransferRepository transferRepositoryRuntimeException = when(mock(TransferRepository.class).transfer(anyLong(), anyLong(), any())).thenThrow(new RuntimeException()).getMock();
	
	@Test
	public void method_transfer_return_by_any_arguments_true() {
		assertTrue(transferRepositoryTrue.transfer(anyLong(), anyLong(), any()));
	}
	
	@Test(expected = RuntimeException.class)
	public void method_transfer_return_by_any_arguments_runtimeexception() {
		assertEquals(RuntimeException.class, transferRepositoryRuntimeException.transfer(anyLong(), anyLong(), any()));
	}
	
}

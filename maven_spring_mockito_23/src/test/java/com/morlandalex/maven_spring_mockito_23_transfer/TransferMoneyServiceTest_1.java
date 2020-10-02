package com.morlandalex.maven_spring_mockito_23_transfer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TransferMoneyServiceTest_1 {

	@Mock
	private AccountRepository accountRepository;
	@Mock
	private TransferRepository transferRepository;
	@Mock
	private TransferMoneyService transferServiceImpl; 
	@Captor
	private ArgumentCaptor<Long> argumentCaptorLong;
	@Captor
	private ArgumentCaptor<BigDecimal> argumentCaptorBigDecimal;
	
	@Test
	public void should_call_method_transferMoney_after_that_method_transfer() {
		BigDecimal bigDecimal = new BigDecimal(111.22);
		doNothing().when(transferServiceImpl).transferMoney(22L,33L,bigDecimal);
		when(transferRepository.transfer(22L, 33L, bigDecimal)).thenReturn(true);
		
		transferServiceImpl.transferMoney(22L, 33L, bigDecimal);
		transferRepository.transfer(22L, 33L, bigDecimal);
		
		InOrder inOrder = inOrder(transferServiceImpl,transferRepository);
		
		inOrder.verify(transferServiceImpl).transferMoney(22L, 33L, bigDecimal);
		inOrder.verify(transferRepository).transfer(22L, 33L, bigDecimal);
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	public void method_transfer_comparison_arguments() {
		when(transferRepository.transfer(longThat(argumentLongFirst -> argumentLongFirst < 500L),
				longThat(argumentLongSecond -> argumentLongSecond < 500L),
				argThat(argumentBigDecimal -> argumentBigDecimal.compareTo(new BigDecimal(4999.00)) <= 0)))
						.thenReturn(true);
		transferRepository.transfer(55L, 77L, new BigDecimal(500.00));
		verify(transferRepository).transfer(longThat(argumentLongFirst -> argumentLongFirst < 500L),
				longThat(argumentLongSecond -> argumentLongSecond < 500L),
				argThat(argumentBigDecimal -> argumentBigDecimal.compareTo(new BigDecimal(4999.00)) <= 0));
	}

	@Test
	public void method_transfer_should_return_true() {
		when(transferRepository.transfer(anyLong(), anyLong(), any())).thenReturn(true);
		assertTrue(transferRepository.transfer(1L, 2L, new BigDecimal(3333.33)));
	}

	@Test
	public void method_transfer_should_return_false() {
		when(transferRepository.transfer(anyLong(), anyLong(), any())).thenReturn(false);
		assertFalse(transferRepository.transfer(3L, 5L, new BigDecimal(333.222)));
	}

	@Test(expected = RuntimeException.class)
	public void method_transfer_should_return_runtimeException() {
		when(transferRepository.transfer(anyLong(), anyLong(), any())).thenThrow(new RuntimeException());
		assertSame(RuntimeException.class, transferRepository.transfer(2L, 3L, new BigDecimal(1111.11)));
		verify(transferRepository, atMostOnce()).transfer(anyLong(), anyLong(), any());
	}

	@Test
	public void method_transfer_checking_arguments() {
		BigDecimal bigDecimal = new BigDecimal(333.300000034);
		transferRepository.transfer(44l, 66l, bigDecimal);
		verify(transferRepository, atMostOnce()).transfer(argumentCaptorLong.capture(), argumentCaptorLong.capture(),
				argumentCaptorBigDecimal.capture());
		List<Long> listArgumentCaptorLong = argumentCaptorLong.getAllValues();
		assertEquals(Long.valueOf(44), listArgumentCaptorLong.get(0));
		assertEquals(Long.valueOf(66), listArgumentCaptorLong.get(1));
		assertEquals(bigDecimal, argumentCaptorBigDecimal.getValue());
	}

}

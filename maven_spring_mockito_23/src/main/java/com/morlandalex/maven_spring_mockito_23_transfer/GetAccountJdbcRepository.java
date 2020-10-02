package com.morlandalex.maven_spring_mockito_23_transfer;

import java.math.BigDecimal;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

public class GetAccountJdbcRepository implements AccountRepository {

	@Override
	public Account getAccountById(Long id) {
		return new JdbcTemplate().queryForObject("select id, name, amount" +
											"from account where id=?",
											
											(ResultSet rs, int rowNum) -> {
												Account account = new AccountCustomers();
												account.setId(rs.getLong("id"));
												account.setFirstName(rs.getString("firstname"));
												account.setLastName(rs.getString("lastname"));
												account.setBankBalance(new BigDecimal(rs.getString("bankbalance")));
												return account;
												
											}, id);
	}

}

package com.bytesvc.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytesvc.provider.service.IAccountService;

@Service("accountServiceConfirm")
public class AccountServiceConfirm implements IAccountService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void increaseAmount(String acctId, double amount) {
		this.jdbcTemplate.update("update tb_account_one set amount = amount - ? where acct_id = ?", amount, acctId);
		System.out.printf("confirm increase: acct= %s, amount= %7.2f%n", acctId, amount);
	}

	@Transactional
	public void decreaseAmount(String acctId, double amount) {
		System.out.printf("confirm decrease: acct= %s, amount= %7.2f%n", acctId, amount);
	}

}

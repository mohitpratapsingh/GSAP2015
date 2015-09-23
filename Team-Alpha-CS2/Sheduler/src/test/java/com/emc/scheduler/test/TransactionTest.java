package com.emc.scheduler.test;


import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.scheduler.service.TransactionService;
import com.emc.sheduler.model.Transactions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-config.xml"})
public class TransactionTest {
	
	@Autowired
	TransactionService transactionService;
	
	@Test
	public void getproducts() {
		Transactions  transaction=transactionService.getTransactionById((long) 1234);
		System.out.println(transaction.getTotalAmount());
		assertNotNull(transaction);
	}

}

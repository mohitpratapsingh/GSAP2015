package com.emc.scheduler.service;

import com.emc.sheduler.model.Transactions;

public interface TransactionService {
	public boolean updateTransaction(Long transactionId);
	public Transactions getTransactionById(Long transactionId);	
}

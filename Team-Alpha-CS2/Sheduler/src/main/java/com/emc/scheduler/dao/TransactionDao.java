package com.emc.scheduler.dao;

import com.emc.sheduler.model.Transactions;

public interface TransactionDao {
public boolean updateTransaction(Long transactionId);
public Transactions getTransactionById(Long transactionId);
}

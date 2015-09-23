package com.emc.scheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.scheduler.dao.TransactionDao;
import com.emc.sheduler.model.Transactions;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao trnsactionDao;
	
	public boolean updateTransaction(Long transactionId) {
		
		return trnsactionDao.updateTransaction(transactionId);
	}

	public Transactions getTransactionById(Long transactionId) {
		
		return trnsactionDao.getTransactionById(transactionId);
	}

}

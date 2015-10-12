package com.emc.shoppingcart.dao;

import javax.transaction.Transaction;

import org.hibernate.HibernateException;

import com.emc.shoppingcart.model.Transactions;

public interface TransactionDao {
	
	Long save(Transactions transaction) throws HibernateException;
	boolean update(Transactions transaction);
	boolean delete(Transactions transaction);
	Transactions retrieveById(Long id) ;

}

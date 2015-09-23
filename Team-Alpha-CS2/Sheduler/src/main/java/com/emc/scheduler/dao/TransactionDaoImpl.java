
package com.emc.scheduler.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emc.sheduler.model.Transactions;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	public boolean updateTransaction(Long transactionId) {
		
		try {
			Session session = sessionfactory.openSession();
			Query query=session.createQuery("update Transactions set status=:newStatus where trascationId= :tId ");
			query.setParameter("newStatus","shipped");
			query.setParameter("tId",transactionId);
			query.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Transactions getTransactionById(Long transactionId) {
		
		try {
			Session session = sessionfactory.openSession();
			Transactions transaction=(Transactions) session
					.get(Transactions.class,transactionId);
			
			return transaction;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}

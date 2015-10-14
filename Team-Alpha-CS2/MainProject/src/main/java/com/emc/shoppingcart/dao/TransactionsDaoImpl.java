package com.emc.shoppingcart.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Orders;
import com.emc.shoppingcart.model.Transactions;


@Repository
public class TransactionsDaoImpl  implements TransactionDao {
	
	@Autowired
	SessionFactory sessionFactory;
	


	@Override
	public Transactions retrieveById(Long id) {
		
		Session session=sessionFactory.openSession();
		Transactions transaction=(Transactions) session.get(Transactions.class,id);
		
		return transaction;
	}


	@Override
	public Long save(Transactions transaction)  throws HibernateException{

		Session session = sessionFactory.openSession();
		return (Long) session.save(transaction);	
	}



	@Override
	public boolean update(Transactions transaction){
		try {
			Session session=sessionFactory.openSession();
			session.update(transaction);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean delete(Transactions transaction) {
		try {
			Session session=sessionFactory.openSession();
			session.delete(transaction);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean inserOrder(Orders order){
		Session session=sessionFactory.openSession();
		session.save(order);
		return true;
	}

		
}
		
		
	




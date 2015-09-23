package com.emc.shoppingcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class TransactionHibernateDaoSupport extends HibernateDaoSupport {

	
	    @Autowired
	    public void myMethod(SessionFactory sessionFactory)
	    {
	        setSessionFactory(sessionFactory);
	    }

	
	
}

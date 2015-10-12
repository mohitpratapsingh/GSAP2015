package com.emc.shoppingcart.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.emc.shoppingcart.dao.TransactionDao;
import com.emc.shoppingcart.model.Orders;
import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.model.Transactions;
import com.emc.shoppingcart.model.User;


@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Override
	public boolean save(Transactions transaction) {
		
		try{
			transactionDao.save(transaction);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
	     
	}

	@Override
	public boolean update(Transactions transaction) {
		
		return transactionDao.update(transaction);
	}

	@Override
	public boolean delete(Transactions transaction) {
		
		return transactionDao.delete(transaction);
	}

	@Override
	public Transactions retrieveById(Long id) {
		
		return transactionDao.retrieveById(id);
	}

	@Override
	public boolean buyProducts(User user, Long totalAmount, List<Product> productsList) {
		
		
/*		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 String transactionDate=sdf.format(new Date());*/
		Transactions tobj = new Transactions(5, new Date(), "placed", totalAmount);
		for (Product product : productsList) {
			Orders orderobj = new Orders(product.getId(), 2, 5000, tobj);
			tobj.getProducts().add(orderobj);
		}
		
		try {
			Long transactionId = transactionDao.save(tobj);
			jmsTemplate.convertAndSend(transactionId);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}
	

}

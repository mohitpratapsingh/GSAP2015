package com.emc.shoppingcart.services;

import java.util.List;

import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.model.Transactions;
import com.emc.shoppingcart.model.User;

public interface TransactionService {

	boolean save(Transactions transaction);
	boolean update(Transactions transaction);
	boolean delete(Transactions transaction);
	Transactions retrieveById(Long id);
	boolean buyProducts(User user,Long totalAmount,List<Product> productsList);

}

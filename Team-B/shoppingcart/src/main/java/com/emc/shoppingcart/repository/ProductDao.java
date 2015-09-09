package com.emc.shoppingcart.repository;

import java.util.List;

import com.emc.shopping.model.Products;
//import com.way2learnonline.model.Account;
	
	
public interface ProductDao {
	//public List<Map<String, Object>> getAllAccountsAsMap();
	//public String findNameByAccountNumber(Long accountNumber);
	//public Account findProductById(Long productId);
	public List<Products> findAllProducts() throws Exception;
	public int saveProduct(Products product) throws Exception ;
	public int deleteProduct(long productId) throws Exception;
	public int updateProduct(Products product,long productId) throws Exception;
}


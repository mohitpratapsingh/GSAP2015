package com.emc.shoppingcart.service;

import java.util.List;

import com.emc.shopping.model.Products;

public interface ProductService {
	public String addProduct(Products p) throws Exception;
	public String updateProduct(Products p) throws Exception;
	public String deleteProduct(Products p) throws Exception;
	public List<Products> findAllProducts() throws Exception;
}

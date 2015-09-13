package com.emc.shoppingcart.repository;

import java.util.List;

import com.emc.shopping.model.Products;

public interface ProductDao {

	public List<Products> findAllProducts() throws Exception;

	public int saveProduct(Products product) throws Exception;

	public int deleteProduct(long productId) throws Exception;

	public int updateProduct(Products product, long productId) throws Exception;
}

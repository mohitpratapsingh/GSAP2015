package com.emc.shoppingcart.dao;

import java.util.List;

import com.emc.shoppingcart.model.Product;

public interface ProductDao {

	public String addProduct(Product product);
	public List<Product> getProducts();
	public String deleteProduct(long productId);
	public String updateProduct(Product product);
	public Product getProductById(int productId);
	public void addproductToFile(Product product) throws Exception;
}

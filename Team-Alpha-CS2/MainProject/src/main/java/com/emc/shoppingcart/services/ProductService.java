package com.emc.shoppingcart.services;

import java.util.List;

import com.emc.shoppingcart.model.Product;

public interface ProductService {

	public String addProduct(Product product);
	public String removeProduct(int productId);
	public Product updateProduct(Product product);
	public List<Product> getProducts();
	public List<Product> getProductsByCategory(String category);
	public List<Product> getProductsByPName(String name);
	public Product getProductsByPId(int id);
	public List<Product> getProductsByBrandName(String brand);
	public List<Product> getProductsByPriceBetween(int from, int to);
	public String removeMultipleProducts(List<Integer> productidList);


}

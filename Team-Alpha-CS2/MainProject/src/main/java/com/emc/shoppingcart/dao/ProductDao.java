package com.emc.shoppingcart.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.emc.shoppingcart.model.Product;

public interface ProductDao extends CrudRepository<Product, String> {

	/*public String addProduct(Product product);
	public List<Product> getProducts();
	public String deleteProduct(long productId);
	public String updateProduct(Product product);
	public Product getProductById(int productId);
	public void addproductToFile(Product product) throws Exception;*/
}

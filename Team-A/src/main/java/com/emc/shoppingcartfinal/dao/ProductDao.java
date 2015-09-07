package com.emc.shoppingcartfinal.dao;

import java.util.List;

import com.emc.shoppingcartfinal.model.Product;

public interface ProductDao {
	
		/*
			 * This is the method to be used for 
			 * entering a new product to the product table.
			 */
			public void insertProduct(Product product);
			
			/*
			 * This is to be used for deleting the
			 * product, to provide delete functionality to the admin
			 */
			public  void deleteProduct(int pId);
			
			/*
			 * This is the method to be used for 
			 * listing all the products.
			 */
			public List<Product> getAllProducts();
			
			/*
			 * This is the method to be used for 
			 * updating the product like its quantity or price 
			 */
			public void updateProduct(Product product, int pId); 


}

package com.emc.shoppingcart.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Product;


public interface ProductDao extends MongoRepository<Product, String>  {
	public List<Product> findByCategory(String category);
	public List<Product> findAll();
	@Query("{ 'pName':{$regex:?0,$options:'i'}} ")
	public List<Product> findByPName(String pName);
	public Product findById(int id);
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceBetween(int from, int to);
	public Product save(Product prod);
	@Query("{ 'id' : ?0 }") 
	public String deleteById(int id);
	

}


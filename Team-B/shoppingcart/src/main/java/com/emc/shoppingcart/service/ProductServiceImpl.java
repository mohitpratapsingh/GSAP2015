package com.emc.shoppingcart.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.emc.shopping.model.Products;
import com.emc.shoppingcart.repository.ProductDao;

//@Component
@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDaoImpl;
    public ProductServiceImpl() {
    	
    }
	public String addProduct(Products p) throws Exception{
		try {
			int count=productDaoImpl.saveProduct(p);
			System.out.println("Service Completed: Product Saved");
			if(count==1)
				return "Product saved successfully";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		}

	
	public List<Products> findAllProducts() throws Exception {
		try{
			List<Products> productList = productDaoImpl.findAllProducts();
			System.out.println("Service Completed: "+productList.size()+" products retrieved");
			return productList;
			
		}
		catch(Exception e){
			throw e;
		}
	}

	public String updateProduct(Products p) throws Exception {
		try{
			int count=productDaoImpl.updateProduct(p,p.getProdId());
			System.out.println("Service Completed: Product with id "+p.getProdId()+" updated");
			if(count==1)
				return "Product" + p.getProdName() + "Successfully updated";
			else
				return null;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
			
	}

	public String deleteProduct(Products p) throws Exception {
		try {
			int count=productDaoImpl.deleteProduct(p.getProdId());
			System.out.println("service Completed: Product with id "+p.getProdId()+" deleted");
			if(count==1)
				return "Product" + p.getProdName() + "Successfully deleted";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		}
	
}

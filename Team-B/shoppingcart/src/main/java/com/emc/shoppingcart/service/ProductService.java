package com.emc.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shopping.model.Products;
import com.emc.shoppingcart.repository.ProductDaoImpl;

@Service(value = "productService")
public class ProductService {
	@Autowired
	ProductDaoImpl productDaoImpl;

	public ProductService() {

	}

	public String addProduct(Products p) throws Exception {
		try {
			int count = productDaoImpl.saveProduct(p);
			System.out.println("Service Completed: Product Saved");
			if (count == 1)
				return "Product saved successfully";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<Products> findAllProducts() throws Exception {
		try {
			List<Products> productList = productDaoImpl.findAllProducts();
			System.out.println("Service Completed: " + productList.size() + " products retrieved");
			return productList;

		} catch (Exception e) {
			throw e;
		}
	}

	public String updateProduct(Products p) throws Exception {
		try {
			int count = productDaoImpl.updateProduct(p, p.getProdId());
			System.out.println("Service Completed: Product with id " + p.getProdId() + " updated");
			if (count == 1)
				return "Product" + p.getProdName() + "Successfully updated";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public String deleteProduct(Products p) throws Exception {
		try {
			int count = productDaoImpl.deleteProduct(p.getProdId());
			System.out.println("service Completed: Product with id " + p.getProdId() + " deleted");
			if (count == 1)
				return "Product" + p.getProdName() + "Successfully deleted";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

package com.emc.shoppingcart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.emc.shoppingcart.dao.ProductDao;
import com.emc.shoppingcart.dao.RolesDao;
import com.emc.shoppingcart.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Autowired
	private PlatformTransactionManager transactionManager;	

	// @Transactional
	public String addProduct(Product product) {

		try {
			productDao.addProduct(product);
			return "SUCCESSFULL_UPDATE";
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return "UPDATE_FAILED";
		}

	}

	@Override
	public String removeProduct(long productId) {

		return productDao.deleteProduct(productId);

	}

	@Override
	public List<Product> getProducts() {
		List<Product> productList=new ArrayList<Product>();
		Product p1=new Product(1, "p", "elctronics", (float) 100, "lg", 5,"d1");
		Product p2=new Product(1, "p", "elctronics", (float) 100, "samsung", 4,"d1");
		Product p3=new Product(1, "p", "elctronics", (float) 100, "onida", 2,"d1");
		//return productDao.getProducts();
		productList.add(p3);
		productList.add(p2);
		productList.add(p1);
		return productList;
	}

	@Override
	public String updateProduct(Product product) {

		return productDao.updateProduct(product);
	}

	@Override
	public String removeMultipleProducts(List<Integer> productidList) {

		List<Integer> notDeleted = new ArrayList<Integer>();
		String failedToDelete = "Could not delete products :";
		for (Integer productId : productidList) {

			String response = productDao.deleteProduct(productId);

			if (response.equals("COULD_NOT_DELETE_PRODUCT")) {
				notDeleted.add(productId);
				failedToDelete = failedToDelete + " " + productId;
			}

		}
		if (notDeleted.size() == 0) {
			return "Successfully deleted the products";
		} else {
			return failedToDelete;
		}

	}


}

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

		return productDao.getProducts();
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

	@Override
	public String transactionExProduct(Product product)  {
		
		DefaultTransactionDefinition transactionDefinition= new DefaultTransactionDefinition();		
		TransactionStatus transactionStatus=transactionManager.getTransaction(transactionDefinition);
		
	 try {
			productDao.addProduct(product);
			productDao.addproductToFile(product);
			transactionManager.commit(transactionStatus);
			return "succesfully added";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transactionManager.rollback(transactionStatus);
			e.printStackTrace();
			return "failed to add product";
		}
		
	}

}

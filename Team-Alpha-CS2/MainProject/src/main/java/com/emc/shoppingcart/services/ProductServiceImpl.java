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

	//@Autowired
	private ProductDao productDao;

//	@Autowired
//	private PlatformTransactionManager transactionManager;	

	// @Transactional
	public String addProduct(Product product) {

		try {
			productDao.save(product);
			return "SUCCESSFULL_UPDATE";
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return "UPDATE_FAILED";
		}

	}

	@Override
	public String removeProduct(int productId) {

		return productDao.deleteById(productId);

	}

	@Override
	public List<Product> getProducts() {


		return productDao.findAll();

	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {

		return productDao.findByCategory(category);
	}
	
	@Override
	public List<Product> getProductsByPName(String name) {

		return productDao.findByPName(name);
	}
	
	@Override
	public Product getProductsByPId(int id) {

		return productDao.findById(id);
	}
	
	@Override
	public List<Product> getProductsByBrandName(String brand) {

		return productDao.findByBrand(brand);
	}
	
	@Override
	public List<Product> getProductsByPriceBetween(int from, int to) {

		return productDao.findByPriceBetween(from,to);
	}
	@Override
	public Product updateProduct(Product product) {

		return productDao.save(product);
	}

	@Override
	public String removeMultipleProducts(List<Integer> productidList) {

		List<Integer> notDeleted = new ArrayList<Integer>();
		String failedToDelete = "Could not delete products :";
		for (Integer productId : productidList) {

			String response = productDao.deleteById(productId);

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


	/*@Override
	public String transactionExProduct(Product product)  {
		
		DefaultTransactionDefinition transactionDefinition= new DefaultTransactionDefinition();		
		TransactionStatus transactionStatus=transactionManager.getTransaction(transactionDefinition);
		
	 try {
			productDao.save(product);
			//productDao.addproductToFile(product);
			transactionManager.commit(transactionStatus);
			return "succesfully added";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			transactionManager.rollback(transactionStatus);
			e.printStackTrace();
			return "failed to add product";
		}
		
	}*/


}

package com.shoppingcart.repository.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.emc.shopping.model.Products;
import com.emc.shoppingcart.repository.ProductDaoImpl;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;

public class ProductDaoTests {
	/*@Autowired
	private UserSignupDaoImpl userDaoImpl;
	*/
	private ProductDaoImpl productDaoImpl;
	//FileSystemXmlApplicationContext context;
	
	
	/*
	@Test
	public void testSaveProduct() throws Exception {
		productDaoImpl = new  ProductDaoImpl();
		
		Products p;
		p = new Products("car",200,4);
		assertNotNull(p);
		//System.out.println(u.getFirstName()+ u.getFirstName()+u.getLastName()+u.getEmailId()+u.getPassword()+u.getRoleId()+u.getAddress());
		productDaoImpl.saveProduct(p);
	}
*/
	
/*	@Test
	public void testFindAllProducts() throws Exception  {

		productDaoImpl = new  ProductDaoImpl();
		List<Products> productList = productDaoImpl.findAllProducts();
		assertFalse(productList.isEmpty());
		System.out.println(productList.size());
	
	}*/
/*
	@Test
	public void updateProduct() throws Exception {
		productDaoImpl = new  ProductDaoImpl();
		
		Products p;
		p = new Products("scooter",20000,14);
		p.setProdId(1);
		assertNotNull(p);
		//System.out.println(u.getFirstName()+ u.getFirstName()+u.getLastName()+u.getEmailId()+u.getPassword()+u.getRoleId()+u.getAddress());
		productDaoImpl.updateProduct(p,1);
	}
*/
	/*
	@Test
	public void deleteProduct() throws Exception {
		productDaoImpl = new  ProductDaoImpl();
		//System.out.println(u.getFirstName()+ u.getFirstName()+u.getLastName()+u.getEmailId()+u.getPassword()+u.getRoleId()+u.getAddress());
		productDaoImpl.deleteProduct(1);
	}*/

}

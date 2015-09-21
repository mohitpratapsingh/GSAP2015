package com.emc.shoppingcart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.services.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations={"classpath:servlet-context.xml","classpath:root-context.xml"})
public class ProductTest {

	@Autowired
	ProductService productService;
	
	@Test
	public void getproducts() {
		List<Product> productList = productService.getProducts();
		System.out.println(productList.size());
		assertFalse(productList.isEmpty());
	}

	@Test
	public void addProduct() {
		Product product=new Product("Micromax Canvas 2", 10000f, "Electronics", "canvas");
		String response=productService.addProduct(product);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void deleteProduct() {
		Long productId = 108L; 
		String response=productService.removeProduct(productId);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void updateProduct() {
		Product product=new Product("Micromax Canvas 2", 10000f, "Electronics", "canvas");
		product.setpId(119);
		String response=productService.updateProduct(product);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void deleteMultipleProducts(){
		List<Integer> productIdList = new ArrayList<Integer>();
		productIdList.add(118);
	    String response=productService.removeMultipleProducts(productIdList);
	    System.out.println(response);
	    assertNotNull(response);
	}
	
	@Test
	public void testTransaction(){
		Product product=new Product("transaction product", 10000f, "Electronics", "canvas");
	    String response=productService.transactionExProduct(product);
	    System.out.println(response);
	    assertNotNull(response);
	
	}
	
	
}

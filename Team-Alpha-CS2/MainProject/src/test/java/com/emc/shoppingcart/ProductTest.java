package com.emc.shoppingcart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.shoppingcart.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
// @ContextConfiguration(locations={"classpath:servlet-context.xml","classpath:root-context.xml"})
/* @ContextConfiguration(classes={XMLConfig.class}) */
public class ProductTest {
	@Autowired
	private ProductDao prod;

	/*ApplicationContext mongo = new FileSystemXmlApplicationContext(
			"C:/Users/kalraa2/Documents/GSAP2015/Team-Alpha-CS2/MainProject/src/main/webapp/WEB-INF/spring/root-context.xml");*/
	//MongoOperations mongoOps = (MongoOperations) mongo.getBean("mongoTemplate");
	@Autowired
	MongoOperations mongoOps;

	@Test
	public void testFindByCategory() {
		System.out.println("");
		// List<Product> prodList = prod.findByCategory("watches");
		// assertThat(prodList.size(), equalTo(2));
		// System.out.println(prodList.size());
	}
	/*
	  @Test 
	  public void testFindAll() {
		  
		  List<Product> prodList = prod.findAll(); //assertThat(prodList.size(),
		  equalTo(16)); System.out.println(prodList.size()); 
		}
	  
	 @Test 
	 public void testFindByName(){ 
		 List<Product> prodList = prod.findByPName("grey");
		  
		  System.out.println(prodList.size()); //assertThat(product.getCategory(),
		  equalTo("jeans"));
		  
	  }
	  
	  @Test
	  public void testFindById(){ 
		  Product product = prod.findById(2);
		  System.out.println(product); //assertThat(product.getCategory(),
		  equalTo("shirt"));
		  
	  }
	  
	  @Test
	  public void testFindByBrand() {
		   
		  List<Product> prodList = prod.findByBrand("only");
		  System.out.println(prodList.size()); //assertThat(prodList.size(),
		  equalTo(1)); 
	   }
	  
	  @Test
	  public void testFindByPrice() {
		  
		  List<Product> prodList = prod.findByPriceBetween(1000, 2000);
		  System.out.println(prodList.size()); //assertThat(prodList.size(),
		  equalTo(4)); 
	  }
	  
	  @Test 
	  public void testSave(){ 
		  Product product = new Product();
		  product.setId(16); product.setpName("Roadster Shoes");
		  product.setDescription("Fashionable shoes at cheap price");
		  product.setBrand("roadster"); product.setCategory("shoes");
		  product.setQuantity(10); product.setPrice(1999.25f);
	  prod.save(product);
	  
	  
	  }
	 */

}

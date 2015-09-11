package com.emc.shoppingcart.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.utils.Queries;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//reading queries from properties file
	@Value("${product.get.all}")
	String allProductsGetQuery;
	
	@Value("${product.insert}")
	String productInsertQuery;
	
	@Value("${product.delete}")
	String productDeleteQuery;
	
	@Value("${product.update}")
	String productUpdateQuery;
	
	@Value("${product.get.byId}")
	String getProductByIdQuery;

	@Override
	public String addProduct(Product product) {

		try {
			//String sql = "insert into product(p_name,price,category,image_name)values(?,?,?,?) ";
			jdbcTemplate.update(productInsertQuery, product.getpName(), product.getPrice(), product.getCategory(),
					product.getImageName());
			return "PRODUCT_ADDED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return "COULD_NOT_ADD_PRODUCT";
		}
	}

	@Override
	public List<Product> getProducts() {
		try {
			//String sql = "select * from product";
			List<Product> productList = jdbcTemplate.query(allProductsGetQuery, new BeanPropertyRowMapper<Product>(Product.class));
			return productList;
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String deleteProduct(long productId) {

		try {
			//String sql = "delete from product where p_id=?";
			jdbcTemplate.update(productDeleteQuery, productId);
			return "PRODUCT_DELETED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return "COULD_NOT_DELETE_PRODUCT";
		}

	}

	@Override
	public String updateProduct(Product product) {

		try {
			//String sql = "update product set p_name=?,price=?,category=?,image_name=? where p_id=?";
			jdbcTemplate.update(productUpdateQuery, product.getpName(), product.getPrice(), product.getCategory(),
					product.getImageName(), product.getpId());
			return "PRODUCT_UPDATED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return "PRODUCT_UPDATE_FAILED";
		}
	}

	@Override
	public Product getProductById(int productId) {
		try {
			//String sql = "select * from product where p_id=?";
			Product product = jdbcTemplate.queryForObject(getProductByIdQuery, new Object[] { productId },
					new BeanPropertyRowMapper<Product>(Product.class));
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void addproductToFile(Product product) throws Exception {
		try {

			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("C:\\product_objects5.txt"));
			List<Product> productList = (List<Product>) reader.readObject();
			// List<Product> productList=new ArrayList<Product>();
			productList.add(product);
			reader.close();

			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("C:\\product_objects.txt"));
			// ObjectOutputStream writer=new ObjectOutputStream(new
			// FileOutputStream("product_objects.txt",true));

			writer.writeObject(productList);
			System.out.println("wrote to file");
			writer.close();

//			throw new Exception();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw e;

		} catch (IOException e) {

			e.printStackTrace();
			throw e;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

}

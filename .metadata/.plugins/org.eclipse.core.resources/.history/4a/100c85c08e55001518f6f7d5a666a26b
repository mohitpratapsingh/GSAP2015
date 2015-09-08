package com.emc.shoppingcart.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addProduct(Product product) {

		try {
			String sql = "insert into product(p_name,price,category,image_name)values(?,?,?,?) ";
			jdbcTemplate.update(sql, product.getpName(), product.getPrice(), product.getCategory(),
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
			String sql = "select * from product";
			List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

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
			String sql = "delete from product where p_id=?";
			jdbcTemplate.update(sql, productId);
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
				String sql = "update product set p_name=?,price=?,category=?,image_name=?";
				jdbcTemplate.update(sql, product.getpName(), product.getPrice(), product.getCategory(),
						product.getImageName());
				return "PRODUCT_UPDATED_SUCCESSFULLY";
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println(e.getMessage());
				return "PRODUCT_UPDATE_FAILED";
			}
	}

	@Override
	public Product getProductById(int productId) {
		try {
			String sql = "select * from product where p_id=?";
			Product product = jdbcTemplate.queryForObject(sql, new Object[] { productId },
					new BeanPropertyRowMapper<Product>(Product.class));
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public void addproductToFile(Product product) {
		try {

			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("C:\\product_objects.txt"));
			List<Product> productList = (List<Product>) reader.readObject();
			productList.add(product);
			reader.close();

			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("C:\\product_objects.txt"));
			// ObjectOutputStream writer=new ObjectOutputStream(new
			// FileOutputStream("product_objects.txt",true));

			writer.writeObject(productList);
			System.out.println("wrote to file");
			writer.close();

			// throw new FileNotFoundException();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

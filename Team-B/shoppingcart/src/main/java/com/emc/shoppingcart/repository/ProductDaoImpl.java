package com.emc.shoppingcart.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.shopping.model.Products;

@Repository(value = "productDaoImpl")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Products> findAllProducts() throws Exception {
		try {
			String sql = "select * from products ";
			return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Products>(Products.class));
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	public int saveProduct(Products product) throws Exception {
		try {
			String sql1 = "insert into products (prod_id,prod_name,price,quantity) values(?,?,?,?)";
			int count = jdbcTemplate.update(sql1, product.getProdId(), product.getProdName(), product.getPrice(),
					product.getQuantity());

			String prodFile = "product_" + product.getProdId() + ".ser";
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(prodFile, true));
			writer.writeObject(product);
			System.out.println("Written to disk");
			writer.close();

			System.out.println("New product added");

			return count;

		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	public int updateProduct(Products product, long productId) throws Exception {
		try {
			String sql2 = "update products set prod_name=?,price=?,quantity=? where prod_id=?";
			int count = jdbcTemplate.update(sql2, product.getProdName(), product.getPrice(), product.getQuantity(),
					productId);
			ObjectInputStream reader;
			String prodFile1 = "product_" + product.getProdId() + ".ser";
			reader = new ObjectInputStream(new FileInputStream(prodFile1));
			Products product1 = (Products) reader.readObject();
			reader.close();
			product1.setProdName(product.getProdName());
			product1.setPrice(product.getPrice());
			product1.setQuantity(product.getQuantity());

			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(prodFile1, true));
			writer.writeObject(product1);
			System.out.println("Updated to disk");
			writer.close();
			System.out.println("Product updated");

			return count;

		} catch (Exception e) {

			throw e;
		}
	}

	public int deleteProduct(long productId) throws Exception {
		int count;
		try {
			String sql2 = "delete from products where prod_id=?";
			count = jdbcTemplate.update(sql2, productId);
			System.out.println("Product details deleted");
			return count;
		} catch (Exception e) {
			throw e;
		}
	}

}

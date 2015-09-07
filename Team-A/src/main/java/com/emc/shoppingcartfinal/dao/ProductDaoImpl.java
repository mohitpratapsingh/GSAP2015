package com.emc.shoppingcartfinal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;
@Component
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void insertProduct(Product product) {
		
			String sql = "Insert into product (pId, pName, depID, quantity, price, prodDes) values (?, ?, ?, ?, ?, ?)";	
			jdbcTemplateObject.update(sql, product.getpId(), product.getpName(), product.getDepID(), product.getQuantity(), product.getPrice(), product.getProdDes());
					
					System.out.println("added product data");
					return; 

		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int pId) {
		// TODO Auto-generated method stub
			String sql = "delete from product where pId=?";
			jdbcTemplateObject.update(sql, pId);
					
					System.out.println("Product deleted"); 
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
			String sql = "select * from Product";
					List<Product> productList = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(Product.class));
					//List<User> userlist= jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(User.class));
					return productList; 
	}

	
	
	@Override
	public void updateProduct(Product product, int pId) {
		// TODO Auto-generated method stub
			String sql = "update product set pId=?, pName=?, depID=?, quantity=?, price=?, prodDes=? where pId=? ";
			jdbcTemplateObject.update(sql, product.getpId(), product.getpName(), product.getDepID(), product.getQuantity(), product.getPrice(), product.getProdDes(),pId);
					System.out.println("Updated prdouct list"); 
	}
	
	

}

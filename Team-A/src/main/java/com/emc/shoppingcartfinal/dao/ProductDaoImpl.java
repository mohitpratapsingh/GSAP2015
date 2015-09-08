package com.emc.shoppingcartfinal.dao;

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
import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;
@Component
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void insertProduct(Product product) throws Exception {
		
            
			String sql = "Insert into product (pId, pName, depID, quantity, price, prodDes) values (?, ?, ?, ?, ?, ?)";	
			try{
			jdbcTemplateObject.update(sql, product.getpId(), product.getpName(), product.getDepID(), product.getQuantity(), product.getPrice(), product.getProdDes());
					
					System.out.println("added product data");
					return; 

			}
			catch(Exception e){
				throw new Exception("Product not inserted",e);
			}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int[] pIds) throws Exception {
		// TODO Auto-generated method stub
		
		String deletePids = "";
		try{
		for(int pid:pIds){
			//deletePids = deletePids + pid + ",";
			String sql = "delete from product where pId=?";
			jdbcTemplateObject.update(sql, pid);
		}
		}
		catch(Exception e){
			throw new Exception("Unable to delete",e);
			
		}
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

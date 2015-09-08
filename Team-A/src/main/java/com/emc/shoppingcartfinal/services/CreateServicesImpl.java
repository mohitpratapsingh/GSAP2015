package com.emc.shoppingcartfinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.emc.shoppingcartfinal.dao.ProductDao;
import com.emc.shoppingcartfinal.dao.UserDao;
import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;

@Component
public class CreateServicesImpl implements CreateServices {
	
	@Autowired
	UserDao user1;
	@Autowired
	ProductDao prod1;

	@Override
	public int UserRegistration(User user) {
		try
		{
		user1.insertnewUser(user);
		// TODO Auto-generated method stub
		return 1;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public boolean ProductRegistration(Product prod)
	{
		try
		{
			prod1.insertProduct(prod);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		
	}

	@Override
	public boolean ProductDelete(int[] pIds) {
		// TODO Auto-generated method stub
		try
		{
			prod1.deleteProduct(pIds);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	@Transactional
	public String addProd(Product product)
	{
		try
		{
			prod1.insertProduct(product);
			prod1.addproductToFile(product);
			return "Success";
		}
		catch(Exception e)
		{
			return "Failed";
		}
	}

}

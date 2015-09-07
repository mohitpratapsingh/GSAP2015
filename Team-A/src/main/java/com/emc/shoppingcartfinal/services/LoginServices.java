package com.emc.shoppingcartfinal.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;

@Component
public interface LoginServices {

	public Map<String,Object> Login(String Username, String Password);
	public List<User> GetAllUser();
	public List<Product> GetAllProduct();
	List<User> GetAllUser(int roleId);
	
}

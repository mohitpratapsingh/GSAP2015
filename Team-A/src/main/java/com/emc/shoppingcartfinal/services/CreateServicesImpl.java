package com.emc.shoppingcartfinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.dao.UserDao;
import com.emc.shoppingcartfinal.model.User;

@Component
public class CreateServicesImpl implements CreateServices {
	
	@Autowired
	UserDao user1;

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
			if(e==null)
				System.out.println("hi namrata");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}

}

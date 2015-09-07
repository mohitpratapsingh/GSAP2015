package com.emc.shoppingcartfinal.dao;

import java.util.List;

import com.emc.shoppingcartfinal.model.User;

public interface UserDao {
	
	public void insertnewUser(User user) throws Exception;
	public User getUserByEmailId(String email) throws Exception;
	public List<User> getAllUser();
	public List<User> getAllUsers(int roleId);

}

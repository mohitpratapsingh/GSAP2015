package com.emc.shoppingcart.dao;

import java.util.List;
import java.util.Map;

import com.emc.shoppingcart.model.User;

public interface UserDao {

	public User getUser(String userName);
	public String insertUser(User user);
	public String insertAdmin(User user);
	public String deleteUser(String userName);
	public String updateuser(User user);
	public List<User> getAllUsers();
	public List<User> getUsersByRoleId(int rId);
}

package com.emc.shoppingcart.services;

import java.util.List;
import java.util.Map;

import com.emc.shoppingcart.model.User;

public interface UserService {
	public Map<String,Object> userLogin(String userName,String passwrd);
	public String insertUser(User user);
	public String deleteUser(String userName);
	public List<User> getUsersByRoleId(int rId);
	public List<User> getAllUsers();
	public String updateUser(User user);
	public User getUserByUserName(String userName);
	public String insertAdmin(User user);
	public String deleteMultipleUsers(List<String> userNameList);
}

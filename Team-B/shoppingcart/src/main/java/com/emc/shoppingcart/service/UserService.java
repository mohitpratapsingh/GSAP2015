package com.emc.shoppingcart.service;

import java.util.List;

import com.emc.shopping.model.User;

public interface UserService {
	public String findNameByEmailId(String emailId) throws Exception ;
	public List<User> findAllUserAccounts() throws Exception;
	public List<User> findAllAdmins() throws Exception;
	public User getSpecificUserAccount(String emailID) throws Exception;
}

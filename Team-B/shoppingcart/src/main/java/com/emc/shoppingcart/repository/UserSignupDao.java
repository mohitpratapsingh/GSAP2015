package com.emc.shoppingcart.repository;

import java.util.List;

import com.emc.shopping.model.User;

public interface UserSignupDao {
	public int setUser(User u) throws Exception;

	public int setAdmin(User u) throws Exception;

	public User getUser(String emailId) throws Exception;

	public List<User> findAllUserAccounts() throws Exception;

	public List<User> findAllAdmins() throws Exception;

	public String findNameByEmailId(String emailId) throws Exception;
}

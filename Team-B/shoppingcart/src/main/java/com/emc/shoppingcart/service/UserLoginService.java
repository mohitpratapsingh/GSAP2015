package com.emc.shoppingcart.service;

public interface UserLoginService {
	public String userExists(String emailId, String password) throws Exception;
}

package com.emc.shoppingcart.service;

import com.emc.shopping.model.User;

public interface RegistrationService {
	public String saveUserdetails(User u) throws Exception;
	public String saveAdmin(User u) throws Exception;
}

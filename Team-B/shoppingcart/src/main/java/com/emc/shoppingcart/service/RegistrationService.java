package com.emc.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shopping.model.User;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;

@Service(value = "registerService")
public class RegistrationService {

	@Autowired
	UserSignupDaoImpl userSignup;

	/**
	 * 
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public String saveUserdetails(User u) throws Exception {
		try {
			int count = userSignup.setUser(u);
			System.out.println("User details stored!");
			if (count == 1)
				return "User: " + u.getEmailId() + " saved.";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * @param u
	 * @return
	 * @throws Exception
	 */
	public String saveAdmin(User u) throws Exception {
		try {
			int count = userSignup.setAdmin(u);
			System.out.println("Admin details stored!");
			if (count == 1)
				return "User: " + u.getEmailId() + " saved.";
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}

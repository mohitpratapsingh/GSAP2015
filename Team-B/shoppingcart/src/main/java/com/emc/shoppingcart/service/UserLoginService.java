package com.emc.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shopping.model.User;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;

@Service(value = "userLogin")
public class UserLoginService {

	@Autowired
	public UserSignupDaoImpl userDaoImpl;

	/**
	 * 
	 * @param emailId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public String userExists(String emailId, String password) throws Exception {

		try {
			User user;
			user = userDaoImpl.getUser(emailId);
			System.out.println(user.getFirstName());
			if (user.getPassword().equals(password)) {
				int uid = user.getRoleId();
				if (uid == 1) {

					return "admin";
				} else {
					return "user";

				}
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}

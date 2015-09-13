package com.emc.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shopping.model.User;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;

@Service(value = "listuser")
public class UserService {

	@Autowired
	UserSignupDaoImpl userDaoImpl;

	/**
	 * 
	 * @param emailId
	 * @return
	 * @throws Exception
	 */
	public String findNameByEmailId(String emailId) throws Exception {
		try {
			String name;
			name = userDaoImpl.findNameByEmailId(emailId);
			System.out.println("Service Completed :name for this email ID is" + name);
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllUserAccounts() throws Exception {
		try {
			List<User> userAccountList = userDaoImpl.findAllUserAccounts();
			System.out.println("Service Completed: " + userAccountList.size() + " accounts retrieved");
			return userAccountList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllAdmins() throws Exception {
		try {
			List<User> userAccountList = userDaoImpl.findAllAdmins();
			System.out.println("Service Completed: " + userAccountList.size() + " accounts retrieved");
			return userAccountList;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * 
	 * @param emailID
	 * @return
	 * @throws Exception
	 */
	public User getSpecificUserAccount(String emailID) throws Exception {
		try {
			User u = userDaoImpl.getUser(emailID);
			System.out.println("Service Completed: " + u.getEmailId() + " Name: " + u.getFirstName() + " retreived");
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}

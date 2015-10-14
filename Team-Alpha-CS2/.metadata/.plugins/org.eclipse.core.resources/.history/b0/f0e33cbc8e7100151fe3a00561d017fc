package com.emc.shoppingcart.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.shoppingcart.dao.RolesDao;
import com.emc.shoppingcart.dao.UserDao;
import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.model.Roles;
import com.emc.shoppingcart.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RolesDao rolesDao;

	@Autowired
	ProductService productService;
	// ProductDao productDao;

	@Override
	public Map<String, Object> userLogin(String userName, String passwrd) {

		Map<String, Object> dataMap = new HashMap<String, Object>();

		User user = userDao.getUser(userName);
		if (user != null) {

			if (passwrd.equals(user.getPasswrd())) {

				Roles role = user.getRole();

				if (role.getrName().equals("super_admin")) {

					dataMap.put("role", role.getrName());
					dataMap.put("user", user);

					List<Product> productList = productService.getProducts();
					// List<User> userList=userDao.getAllUsers();
					List<User> userList = userDao.getUsersByRoleId(0);
					List<User> adminList = userDao.getUsersByRoleId(1);

					dataMap.put("productList", productList);
					dataMap.put("userList", userList);
					dataMap.put("adminList", adminList);

					return dataMap;
				} else if (role.getrName().equals("admin")) {

					dataMap.put("role", role.getrName());
					dataMap.put("user", user);

					List<Product> productList = productService.getProducts();
					// List<User> userList=userDao.getAllUsers();
					List<User> userList = userDao.getUsersByRoleId(0);

					dataMap.put("productList", productList);
					dataMap.put("userList", userList);

					return dataMap;
				} else {
					dataMap.put("role", role.getrName());
					dataMap.put("user", user);

					List<Product> productList = productService.getProducts();

					dataMap.put("productList", productList);
					return dataMap;
				}

			} else {
				dataMap.put("message", "password is not correct");
				return dataMap;
			}

		} else {
			dataMap.put("message", "user with this username doesn't exist");
			return dataMap;
		}

	}

	@Override
	public String insertUser(User user) {

		return userDao.insertUser(user);
	}

	@Override
	public String deleteUser(String userName) {

		return userDao.deleteUser(userName);
	}

	@Override
	public List<User> getUsersByRoleId(int rId) {

		return userDao.getUsersByRoleId(rId);
	}

	@Override
	public List<User> getAllUsers() {

		return userDao.getAllUsers();
	}

	@Override
	public String updateUser(User user) {

		return userDao.updateuser(user);
	}

	@Override
	public User getUserByUserName(String userName) {

		return userDao.getUser(userName);
	}

	@Override
	public String insertAdmin(User user) {

		return userDao.insertAdmin(user);
	}

	@Override
	public String deleteMultipleUsers(List<String> usernameList) {
		List<String> notDeleted = new ArrayList<String>();
		String failedToDelete = "Could not delete users :";
		for (String userName : usernameList) {

			String response = userDao.deleteUser(userName);

			if (response.equals("USER_DELETION_FAILED")) {
				notDeleted.add(userName);
				failedToDelete = failedToDelete + " " + userName;
			}

		}
		if (notDeleted.size() == 0) {
			return "Successfully deleted the users";
		} else {
			return failedToDelete;
		}

	}

}
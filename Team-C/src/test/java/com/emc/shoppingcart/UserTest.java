package com.emc.shoppingcart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.shoppingcart.model.User;
import com.emc.shoppingcart.services.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml","file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@ContextConfiguration(locations={"classpath:servlet-context.xml","classpath:root-context.xml"})
public class UserTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testGetUsersByRoleId(){
		System.out.println("test");
		List<User> userlist=userService.getUsersByRoleId(0);
		for(User user:userlist){
			System.out.println(user.getUserFname());
		}
		assertFalse(userlist.isEmpty());
	}
	
	@Test
	public void UserLogin(){
		String userName= "rubin@emc.com";
		String passwrd="root";
		Map<String,Object> dataMap = userService.userLogin(userName, passwrd);
		System.out.println(dataMap.get("message"));
		assertNotNull(dataMap);
	}
	
	@Test
	public void insertUser(){
		User user = new User("male", "Wayne", "Rooney", "rooney@emc.com", "root", "Manchester","England", 1234567L );
		String response = userService.insertUser(user);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void deleteUser(){
		String userName = "rooney@emc.com";
		String response = userService.deleteUser(userName);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void updateUser(){
		User user = new User("male", "Wayne", "Rooney", "rooney@emc.com", "root", "Manchester","England", 1234567L );
		user.setuId(71);
		String response = userService.updateUser(user);
		System.out.println(response);
		assertNotNull(response);
	}
	
	@Test
	public void getAllUsers(){
		List<User> userList = userService.getAllUsers();
		System.out.println(userList.size());
		assertFalse(userList.isEmpty());
	}
	
	@Test
	public void getUserByUserName(){
		String userName = "rooney@emc.com";
		User user = userService.getUserByUserName(userName);
		System.out.println(user.getUserFname());
		assertNotNull(user);
	}
	
	@Test
	public void insertAdmin(){
		User user = new User("male", "Bastian", "Schweinsteiger", "bastian@emc.com", "root", "Manchester","England", 1234567L );
		String response = userService.insertAdmin(user);
		System.out.println(response);
		assertNotNull(response);
	}
	
	
}

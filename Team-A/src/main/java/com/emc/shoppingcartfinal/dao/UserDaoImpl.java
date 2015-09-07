package com.emc.shoppingcartfinal.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.model.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	@Override
	public void insertnewUser(User user) throws Exception {
		
		String sql = "INSERT INTO USERS " +
				"(FNAME,LNAME,EMAILID,ADDRESSLINE1,ADDRESSLINE2,CITY,STATE,COUNTRY,PINCODE,PASSWORD,ROLEID)"
				+ " VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";
		//System.out.println(user.getFname());
		try{
		 int insertedRecords = jdbcTemplateObject.update(sql, user.getFname(),user.getLname(),user.getEmailId(),user.getAddressLine1()
				,user.getAddressLine2(),user.getCity(),user.getState(),user.getCountry(),user.getPincode(),
				user.getPassword(),user.getRoleID());
		 if(insertedRecords == 0) {
			 throw new Exception("user not inserted");
		 }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("User not inserted",e);
		}
		
		
	}

	@Override
	public User getUserByEmailId(String email) throws Exception {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM USERS WHERE EMAILID=?";
		try{
		User user=(User) jdbcTemplateObject.queryForObject(sql,new Object[]{email},new BeanPropertyRowMapper<User>(User.class));
		//System.out.println(user.getCountry());
		
		return user;
		}
		catch(Exception e)
		{
			throw new Exception("User not found", e);
			
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Users";  
		  List<User> userlist= jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(User.class));  
		  return userlist; 
	}
	

		@Override
			public List<User> getAllUsers(int roleId) {
				
				String sql = "SELECT * FROM Users where roleId=?";  
				  List<User> userlist= jdbcTemplateObject.query(sql,new Object[]{roleId},new BeanPropertyRowMapper(User.class));  
				  return userlist; 
			} 


	

}

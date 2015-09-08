package com.emc.shoppingcart.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.mappers.UserRoleMapper;
import com.emc.shoppingcart.model.User;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public User getUser(String userName) {

		try {
			String sql = "select * from user where email_id=?";
			User user = jdbcTemplate.queryForObject(sql, new Object[] { userName },
					new BeanPropertyRowMapper<User>(User.class));

			return user;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String insertUser(User user) {

		try {
			String sql = "insert into user(user_lname,user_fname,email_id,passwrd,address_line1,address_line2,phone_number,gender,r_id) values(?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, user.getUserLname(), user.getUserFname(), user.getEmailId(), user.getPasswrd(),
					user.getAddressLine1(), user.getAddressLine2(), user.getPhoneNumber(), user.getGender(), 0);

			return "USER_ADDED_SUCCESSFULLY";

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return "COULD_NOT_ADD_USER";
		}

	}

	@Override
	public String deleteUser(String userName) {
		try {
			String sql = "delete from user where email_id=?";
			jdbcTemplate.update(sql, userName);
			return "USER_DELETED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return "USER_DELETION_FAILED";
		}

	}

	@Override
	public String updateuser(User user) {

		try {
			String sql = "update user set user_lname=?,user_fname=?,email_id=?,passwrd=?,address_line1=?,address_line2=?,phone_number=?,gender=?";
			jdbcTemplate.update(sql, user.getUserLname(), user.getUserFname(), user.getEmailId(), user.getPasswrd(),
					user.getAddressLine1(), user.getAddressLine2(), user.getPhoneNumber(), user.getGender());
			return "USER_UPDATED_SUCCESSFULLY";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "USER_UPDATE_FAILED";
		}
	}

	@Override
	public List<User> getAllUsers() {

		try {
			String sql = "select * from user";
			List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<User> getUsersByRoleId(int rId) {

		try {
			String sql = "select * from user where r_id=?";
			List<User> userListByRole;
			userListByRole = jdbcTemplate.query(sql, new Object[] { rId }, new BeanPropertyRowMapper<User>(User.class));

			return userListByRole;
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public String insertAdmin(User user) {
		try{
		String sql="insert into user(user_lname,user_fname,email_id,passwrd,r_id) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,user.getUserLname(),user.getUserFname(),user.getEmailId(),user.getPasswrd(),1);
		return "ADMIN_ADDED_SUCCESSFULLY";
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return "COULD_NOT_ADD_ADMIN";
		}
		
	}

}

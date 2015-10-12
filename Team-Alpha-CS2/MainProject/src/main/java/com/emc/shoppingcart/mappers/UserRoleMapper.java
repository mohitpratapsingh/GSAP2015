package com.emc.shoppingcart.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emc.shoppingcart.model.User;

public class UserRoleMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();	
		user.setuId(rs.getInt("u_id"));
		user.setUserFname(rs.getString("user_fname"));
		user.setUserLname(rs.getString("user_lname"));
		user.setEmailId(rs.getString("email_id"));
		user.setPasswrd(rs.getString("passwrd"));
		user.setAddressLine1(rs.getString("address_line1"));
		user.setAddressLine2(rs.getString("address_line2"));
		user.setPhoneNumber(rs.getLong("phone_number"));
		user.setGender(rs.getString("gender"));
	
		return user;
	}

}

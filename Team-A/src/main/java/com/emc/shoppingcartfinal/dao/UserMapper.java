package com.emc.shoppingcartfinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.emc.shoppingcartfinal.model.User;

public class UserMapper implements RowMapper{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user1= new User();
		user1.setFname(rs.getString(1));
		user1.setLname(rs.getString(2));
		user1.setEmailId(rs.getString(3));
		user1.setAddressLine1(rs.getString(4));
		user1.setAddressLine2(rs.getString(5));
		user1.setCity(rs.getString(6));
		user1.setState(rs.getString(7));
		user1.setCountry(rs.getString(8));
		user1.setPincode(rs.getInt(9));
		user1.setPassword(rs.getString(10));
		user1.setRoleID(rs.getInt(11));
		
		return user1;
	}

}

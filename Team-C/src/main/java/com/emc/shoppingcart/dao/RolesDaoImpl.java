package com.emc.shoppingcart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Roles;

@Repository
public class RolesDaoImpl implements RolesDao{

	@Autowired
	JdbcTemplate jdbctemplate;
	
	@Override
	public Roles getRole(int rId) {
		try{
		String sql="select * from roles where r_id=?";
		Roles role=jdbctemplate.queryForObject(sql,new Object[]{rId}, new BeanPropertyRowMapper<Roles>(Roles.class));
		return role;
		}
		catch(Exception e){
			e.printStackTrace();
			//System.out.println(e.getMessage());
			return null;
		}
	}

}

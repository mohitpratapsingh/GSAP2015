package com.emc.shoppingcart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Roles;

@Repository
public class RolesDaoImpl implements RolesDao {

	@Autowired
	JdbcTemplate jdbctemplate;
	
	//reading queries from properties file
	@Value("${roles.get.byId}")
	String getRoleByIdQuery;
	
	@Value("${roles.insert}")
	String roleInsertQuery;

	@Override
	public Roles getRole(int rId) {
		try {
			//String sql = "select * from roles where r_id=?";
			Roles role = jdbctemplate.queryForObject(getRoleByIdQuery, new Object[] { rId },
					new BeanPropertyRowMapper<Roles>(Roles.class));
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean insertRole(Roles role) {
		//String sql = "insert into roles(r_name) values(?)";
		jdbctemplate.update(roleInsertQuery, role.getrName());
		return true;
	}

}

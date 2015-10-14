package com.emc.shoppingcart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Roles;
import com.emc.shoppingcart.model.User;

@Repository
public class RolesDaoImpl implements RolesDao {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public Roles getRole(int rId) {
		try {
			return (Roles) this.sessionFactory.openSession().get(Roles.class,rId);

	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public boolean insertRole(Roles role) {
		try{
			sessionFactory.openSession().saveOrUpdate(role);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
	}

}

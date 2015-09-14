package com.emc.shoppingcart.repository;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emc.shopping.model.User;

@Repository(value = "userDaoImpl")
public class UserSignupDaoImpl implements UserSignupDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Override
	@Transactional
	public int setUser(User u) throws Exception {
		try {
			String sql = "insert into users (first_name,last_name,email_id,password,role_id,address) values(?,?,?,?,?,?)";
			int count = jdbcTemplate.update(sql, u.getFirstName(), u.getLastName(), u.getEmailId(), u.getPassword(), 2,
					u.getAddress());
			System.out.println("User Account Created");

			String userFile = "user_" + u.getEmailId() + ".ser";
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userFile, true));
			writer.writeObject(u);
			System.out.println("Written to disk");
			writer.close();

			return count;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 */
	@Override
	@Transactional
	public int setAdmin(User u) throws Exception {
		try {
			String sql = "insert into users (first_name,last_name,email_id,password,role_id,address) values(?,?,?,?,?,?)";
			int count = jdbcTemplate.update(sql, u.getFirstName(), u.getLastName(), u.getEmailId(), u.getPassword(), 1,
					u.getAddress());
			System.out.println("Admin Account Created");

			String userFile = "user_" + u.getEmailId() + ".ser";
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(userFile, true));
			writer.writeObject(u);
			System.out.println("Written to disk");
			writer.close();
			return count;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 */
	@Override
	public User getUser(String emailId) throws Exception {
		try {
			User user;
			String sql = "select * from users where email_id=?";
			user = jdbcTemplate.queryForObject(sql, new Object[] { emailId },
					new BeanPropertyRowMapper<User>(User.class));
			System.out.println(user.getEmailId());
			return user;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 */
	public List<User> findAllUserAccounts() throws Exception {
		try {
			String query = "select u.first_name,u.last_name,u.email_id from users u where u.role_id = 2";
			return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 */
	public String findNameByEmailId(String emailId) throws Exception {
		try {
			String sql = "select first_name from users where email_id = ?";
			String sql1 = "select last_name from users where email_id = ?";
			String firstName = jdbcTemplate.queryForObject(sql, new Object[] { emailId }, String.class);
			String lastName = jdbcTemplate.queryForObject(sql1, new Object[] { emailId }, String.class);
			return firstName + " " + lastName;
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * 
	 */
	public List<User> findAllAdmins() throws Exception {
		try {
			String query = "select u.first_name,u.last_name,u.email_id from users u where u.role_id = 1";
			return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
			throw e;
		}
	}

}

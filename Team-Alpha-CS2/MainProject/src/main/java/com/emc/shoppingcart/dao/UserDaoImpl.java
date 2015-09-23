
package com.emc.shoppingcart.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	@Autowired
	SessionFactory sessionFactory;
	/*@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	//reading queries from properties file
	@Value("${user.insert}")
	String userInsertQuery;
	
	@Value("${user.delete}")
	String userDeleteQuery;
	
	@Value("${user.update}")
	String userUpdateQuery;
	
	@Value("${user.get.all}")
	String allUserGetQuery;
	
	@Value("${user.get.byUserName}")
	String userGetByUserNameQuery;
	
	@Value("${user.get.byRoleId}")
	String userGetByRoleQuery;
	
	@Value("${user.insert.admin}")
	String userInsertAdminQuery;
*/
	@Override
	public User getUser(String userName) {

		try {

			//String sql = "select * from user where email_id=?";
			/*User user = jdbcTemplate.queryForObject(userGetByUserNameQuery, new Object[] { userName },
					new BeanPropertyRowMapper<User>(User.class));*/
			/*return (User) this.sessionFactory.getCurrentSession()
					.createQuery("from user where email_id=? ") 
					.setParameter(0, userName);*/
				return (User) this.sessionFactory.getCurrentSession().get(userName, User.class)	;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insertUser(User user) {

		try {

			//String sql = "insert into user(user_lname,user_fname,email_id,passwrd,address_line1,address_line2,phone_number,gender,r_id) values(?,?,?,?,?,?,?,?,?)";
			/*jdbcTemplate.update(userInsertQuery, user.getUserLname(), user.getUserFname(), user.getEmailId(), user.getPasswrd(),

					user.getAddressLine1(), user.getAddressLine2(), user.getPhoneNumber(), user.getGender(), 0);
			*/
			
			/*return "USER_ADDED_SUCCESSFULLY";*/
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return "USER_ADDED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();

			return "COULD_NOT_ADD_USER";
		}

	}

	@Override
	public String deleteUser(String userName) {
		try {

			//String sql = "delete from user where email_id=?";
			//jdbcTemplate.update(userDeleteQuery, userName);
			sessionFactory.getCurrentSession().delete(userName, User.class);

			return "USER_DELETED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			return "USER_DELETION_FAILED";
		}

	}

	@Override
	public String updateuser(User user) {

		try {

			//String sql = "update user set user_lname=?,user_fname=?,email_id=?,passwrd=?,address_line1=?,address_line2=?,phone_number=?,gender=? where u_id=?";
			/*jdbcTemplate.update(userUpdateQuery, user.getUserLname(), user.getUserFname(), user.getEmailId(), user.getPasswrd(),

					user.getAddressLine1(), user.getAddressLine2(), user.getPhoneNumber(), user.getGender(),
					user.getuId());*/
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return "USER_UPDATED_SUCCESSFULLY";

		} catch (Exception e) {
			e.printStackTrace();
			return "USER_UPDATE_FAILED";
		}
	}

	@Override
	public List<User> getAllUsers() {

		try {

			//String sql = "select * from user";
			//List<User> userList = jdbcTemplate.query(allUserGetQuery, new BeanPropertyRowMapper<User>(User.class));
			
			return this.sessionFactory.getCurrentSession().createQuery("from user").list();


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getUsersByRoleId(int rId) {

		try {

			//String sql = "select * from user where r_id=?";
			/*List<User> userListByRole;
			userListByRole = jdbcTemplate.query(userGetByRoleQuery, new Object[] { rId }, new BeanPropertyRowMapper<User>(User.class));
*/
			return this.sessionFactory.getCurrentSession()
	                .createQuery("from user where r_id = ?")
	                .setParameter(0, rId)
	                .list();


			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insertAdmin(User user) {
		try {

			//String sql = "insert into user(user_lname,user_fname,email_id,passwrd,r_id) values(?,?,?,?,?)";
			//jdbcTemplate.update(userInsertAdminQuery, user.getUserLname(), user.getUserFname(), user.getEmailId(), user.getPasswrd(), 1);
			user.setR_id(1);
			sessionFactory.getCurrentSession().saveOrUpdate(user);

			return "ADMIN_ADDED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			return "COULD_NOT_ADD_ADMIN";
		}

	}

}


package com.emc.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emc.shoppingcart.model.Roles;
import com.emc.shoppingcart.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	RolesDao rolesDao;

	@Override
	public User getUser(String userName) {

		try {
			//return (User) this.sessionFactory.openSession().get(User.class, userName);
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User where  emailId= :emailId");
			query.setParameter("emailId",userName);
			return (User) query.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insertUser(User user) {

		try {
			Roles role = rolesDao.getRole(0);
			user.setRole(role);
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

			return this.sessionFactory.getCurrentSession().createQuery("from user").list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getUsersByRoleId(int rId) {

		try {

			return this.sessionFactory.getCurrentSession().createQuery("from user where r_id = ?").setParameter(0, rId)
					.list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insertAdmin(User user) {
		try {

			Roles role = rolesDao.getRole(1);
			user.setRole(role);
			sessionFactory.getCurrentSession().saveOrUpdate(user);

			return "ADMIN_ADDED_SUCCESSFULLY";
		} catch (Exception e) {
			e.printStackTrace();
			return "COULD_NOT_ADD_ADMIN";
		}

	}

}
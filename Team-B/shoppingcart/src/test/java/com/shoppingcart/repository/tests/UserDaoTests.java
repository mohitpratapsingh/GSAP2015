package com.shoppingcart.repository.tests;

import com.emc.shoppingcart.repository.UserSignupDaoImpl;

public class UserDaoTests {

	private UserSignupDaoImpl userDaoImpl;
	// FileSystemXmlApplicationContext context;

	/*
	 * @Test public void testSaveUser() throws Exception { userDaoImpl = new
	 * UserSignupDaoImpl();
	 * 
	 * User u; u = new User("ghi","Tripathi","tripsghi@gmail.com","a123458",2,
	 * "Madhu Vihar,patparganj,New Delhi");
	 * //System.out.println(u.getFirstName()+
	 * u.getFirstName()+u.getLastName()+u.getEmailId()+u.getPassword()+u.
	 * getRoleId()+u.getAddress()); userDaoImpl.getUser(u.getEmailId()); }
	 */

	/*
	 * @Test public void testFindNameByEmailId() throws Exception { userDaoImpl
	 * = new UserSignupDaoImpl(); String name; name =
	 * userDaoImpl.findNameByEmailId("tripsghi@gmail.com"); assertNotNull(name);
	 * System.out.println(name); }
	 */

	/*
	 * @Test public void testFindAllUserAccounts() throws Exception {
	 * userDaoImpl = new UserSignupDaoImpl(); List<User> userAccountList =
	 * userDaoImpl.findAllUserAccounts();
	 * assertFalse(userAccountList.isEmpty());
	 * System.out.println(userAccountList.size()); //assert }
	 * 
	 */

	/*
	 * @Test public void updateUserRole() throws Exception { userDaoImpl = new
	 * UserSignupDaoImpl(); userDaoImpl.updateUserRole(8); }
	 */

	/*
	 * @Test public void testOneUser() throws Exception{ //context=new
	 * FileSystemXmlApplicationContext("file:C://root-context.xml"); userDaoImpl
	 * = new UserSignupDaoImpl();
	 * 
	 * try { User u = userDaoImpl.getUser("tripsghi@gmail.com");
	 * assertNotNull(u); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void findAllAdmins() throws Exception { userDaoImpl = new
	 * UserSignupDaoImpl(); //String sql =
	 * "select u.first_name,u.last_name,u.email_id from users u where u.role_id = 1"
	 * ; List<User> adminAccountList = userDaoImpl.findAllAdmins();
	 * assertFalse(adminAccountList.isEmpty());
	 * System.out.println(adminAccountList.size()); //return
	 * JdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	 * 
	 */
}

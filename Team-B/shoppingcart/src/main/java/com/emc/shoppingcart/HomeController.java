package com.emc.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emc.shopping.model.Products;
import com.emc.shopping.model.User;
import com.emc.shopping.model.UserLogin;
import com.emc.shoppingcart.repository.ProductDaoImpl;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;
import com.emc.shoppingcart.service.ProductService;
//import com.emc.shoppingcart.service.ListUsersService;
//import com.emc.shoppingcart.repository.User_dao;
import com.emc.shoppingcart.service.UserLoginService;
import com.emc.shoppingcart.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public static HttpSession session;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	UserLoginService userLogin;
	@Autowired
	UserService listuser;
	@Autowired
	ProductDaoImpl product;
	@Autowired
	ProductService product1;
	@Autowired
	UserSignupDaoImpl user3, user4;
	@Autowired
	ProductService product2;

	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		try {
			logger.info("Welcome home! The client locale is {}.", locale);
			UserLogin user = new UserLogin();
			model.addAttribute("loginForm", user);

			return "userLogin";
		} catch (Exception e) {
			String errormsg = "Error in loading login page";
			model.addAttribute("error", errormsg);
			return "userLogin";

		}
	}

	/**
	 * 
	 * @param user
	 * @param Result
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/userLoginSubmit", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("loginForm") @Valid UserLogin user, BindingResult Result, Model model,
			HttpServletRequest request) {
		if (Result.hasErrors()) {
			return "userLogin";
		} else {
			try {

				String str;

				str = userLogin.userExists(user.getEmailId(), user.getPassword());
				session = request.getSession();
				session.setAttribute("emailId", user.getEmailId());

				if (str.equals("admin")) {

					model.addAttribute("Name", user4.findNameByEmailId(user.getEmailId()));

					List<Products> allProduct = new ArrayList<Products>();
					allProduct = product1.findAllProducts();
					model.addAttribute("Productlist", allProduct);

					List<User> alluser = new ArrayList<User>();
					alluser = listuser.findAllUserAccounts();
					model.addAttribute("UserList", alluser);

					List<User> alladmin = new ArrayList<User>();
					alladmin = listuser.findAllAdmins();
					model.addAttribute("AdminList", alladmin);
					return "AdminLanding";
				} else if (str.equals("user")) {
					model.addAttribute("Name", user4.findNameByEmailId(user.getEmailId()));
					List<Products> allProduct = new ArrayList<Products>();
					allProduct = product1.findAllProducts();
					model.addAttribute("Productlist", allProduct);
					return "UserLanding";
				} else {
					model.addAttribute("User Doesn't Exist", "error");
					return "userLogin";
				}
			} catch (Exception e) {
				String error = "Error in signing in the user";
				model.addAttribute("error", error);
				return "userLogin";
			}

		}

	}

	/**
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/adminLanding", method = RequestMethod.POST)
	public String adminPage(@ModelAttribute("adminList") User user1, Model model, HttpServletRequest request) {
		try {
			System.out.println("Email:" + request.getParameter("session"));
			String emailId = request.getParameter("session");
			User user = listuser.getSpecificUserAccount(emailId);
			model.addAttribute("Name", listuser.findNameByEmailId(user.getEmailId()));

			List<Products> allProduct = new ArrayList<Products>();
			allProduct = product1.findAllProducts();
			model.addAttribute("Productlist", allProduct);

			List<User> alluser = new ArrayList<User>();
			alluser = listuser.findAllUserAccounts();
			model.addAttribute("UserList", alluser);

			List<User> alladmin = new ArrayList<User>();
			alladmin = listuser.findAllAdmins();
			model.addAttribute("AdminList", alladmin);
			return "AdminLanding";
		} catch (Exception e) {
			String error = "Error in retriving home page for admin user";
			model.addAttribute("error", error);
			return "AdminLanding";
		}

	}

	/**
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ProductForm", method = RequestMethod.POST)
	public String prodPage(@ModelAttribute("prodForm") Products p, Model model) {
		Products product = new Products();
		model.addAttribute("prodFormSubmit", product);
		return "ProductForm";
	}

	/**
	 * @author tripaa5
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createAdmin", method = RequestMethod.GET)
	public String viewRegistration(Model model) {

		User adminForm = new User();
		System.out.println("Register Admin");
		model.addAttribute("adminForm", adminForm);
		return "AdminRegister";

	}

}

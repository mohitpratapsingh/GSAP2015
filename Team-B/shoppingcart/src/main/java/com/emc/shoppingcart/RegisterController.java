package com.emc.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emc.shopping.model.Products;
import com.emc.shopping.model.User;
import com.emc.shoppingcart.repository.ProductDaoImpl;
import com.emc.shoppingcart.repository.UserSignupDaoImpl;
import com.emc.shoppingcart.service.ProductService;
import com.emc.shoppingcart.service.RegistrationService;
import com.emc.shoppingcart.service.UserLoginService;
import com.emc.shoppingcart.service.UserService;

@Controller

public class RegisterController {

	@Autowired
	RegistrationService registerService;

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
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public String viewRegistration(Model model) {

		User userForm = new User();
		System.out.println("Register");
		model.addAttribute("userForm", userForm);

		return "Registration";

	}

	/**
	 * 
	 * @param user
	 * @param result2
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") @Valid User user, BindingResult result2,
			Model model) {
		if (result2.hasErrors()) {
			return "Registration";
		}
		// registration logic here...
		try {
			registerService.saveUserdetails(user);

			// for testing purpose:
			System.out.println("firstname: " + user.getFirstName());
			System.out.println("lastname: " + user.getLastName());
			System.out.println("password: " + user.getPassword());
			System.out.println("email: " + user.getEmailId());
			System.out.println("email: " + user.getAddress());
			model.addAttribute("Name", user4.findNameByEmailId(user.getEmailId()));
			List<Products> allProduct = new ArrayList<Products>();
			allProduct = product1.findAllProducts();
			model.addAttribute("Productlist", allProduct);

			return "UserLanding";
		} catch (Exception e) {
			String error = "Error in saving user";
			model.addAttribute("error", error);
			return "Registration";
		}

	}

	@RequestMapping(value = "/registerAdmin", method = RequestMethod.POST)
	public String adminRegistration(@ModelAttribute("adminForm") @Valid User user, BindingResult result2, Model model,
			HttpServletRequest request) {
		try {
			// registration logic here...
			System.out.println("reaching the function");
			registerService.saveAdmin(user);
			if (result2.hasErrors()) {
				return "AdminRegister";
			}

			System.out.println("Email:" + request.getParameter("session"));
			String emailId = request.getParameter("session");
			User user1 = listuser.getSpecificUserAccount(emailId);
			model.addAttribute("Name", listuser.findNameByEmailId(user1.getEmailId()));

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
			String error = "Error in saving admin";
			model.addAttribute("error", error);
			return "AdminLanding";

		}

	}

}

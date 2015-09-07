package com.emc.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emc.shoppingcart.model.Product;
import com.emc.shoppingcart.model.User;
import com.emc.shoppingcart.model.UserLogin;
import com.emc.shoppingcart.services.ProductService;
import com.emc.shoppingcart.services.UserService;
import com.emc.shoppingcart.utils.ConstantsClass;

@Controller
public class ShoppingController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		UserLogin login = new UserLogin();
		model.addAttribute("loginForm", login);
		return "userLoginForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model, HttpSession session) {
		User user = new User();
		List<String> stateList = new ArrayList<String>();
		stateList.add("Karnataka");
		stateList.add("kerala");
		stateList.add("orissa");
		stateList.add("punjab");
		stateList.add("goa");
		model.addAttribute("registerForm", user);
		model.addAttribute("stateList", stateList);
		session.setAttribute("stateList", stateList);
		return "userRegistrationForm";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String signupUser(@ModelAttribute("registerForm") User user, Model model, BindingResult bindingResult,
			HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "userRegistrationForm";
		} else {
			String response = userService.insertUser(user);
			if (response.equals("USER_ADDED_SUCCESSFULLY")) {
				UserLogin login = new UserLogin();
				model.addAttribute("loginForm", login);
				return "userLoginForm";
			} else {
				model.addAttribute("response", "user with username already existss");
				User user1 = new User();
				model.addAttribute("registerForm", user);
				List<String> stateList = (List<String>) session.getAttribute("stateList");
				model.addAttribute("stateList", stateList);
				return "userRegistrationForm";
				// return "redirect:/register";
			}

		}
	}

	@RequestMapping(value = "/adminRegForm", method = RequestMethod.GET)
	public String registeradmin(Model model) {
		User user = new User();
		model.addAttribute("adminForm", user);
		return "adminRegistrationForm";
	}

	@RequestMapping(value = "/adminRegistration", method = RequestMethod.POST)
	public String addAdmin(@ModelAttribute("adminForm") User user, Model model, HttpSession session) {
		Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
		String response = userService.insertAdmin(user);
		List<Product> productList = productService.getProducts();
		List<User> userList = userService.getUsersByRoleId(ConstantsClass.USER_ID);
		dataMap.put("productList", productList);
		dataMap.put("userList", userList);

		if (response.equals("ADMIN_ADDED_SUCCESSFULLY")) {
			List<User> adminList = userService.getUsersByRoleId(ConstantsClass.ADMIN_ID);
			dataMap.put("adminList", adminList);
			dataMap.put("admin_add_message", response);
		} else
			dataMap.put("admin_add_message", response);

		model.addAttribute("dataMap", dataMap);
		session.setAttribute("dataMap", dataMap);

		return "superAdminHome";
	}

	@RequestMapping(value = "/deleteAdmin", method = RequestMethod.GET)
	public String removeAdmin(@RequestParam("userName") String userName, Model model, HttpSession session) {
		Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
		String response = userService.deleteUser(userName);

		List<Product> productList = productService.getProducts();
		List<User> userList = userService.getUsersByRoleId(ConstantsClass.USER_ID);
		dataMap.put("productList", productList);
		dataMap.put("userList", userList);

		if (response.equals("USER_DELETED_SUCCESSFULLY")) {
			List<User> adminList = userService.getUsersByRoleId(ConstantsClass.ADMIN_ID);
			dataMap.put("adminList", adminList);
			dataMap.put("admin_add_message", "ADMIN DELETED SUCCESFULLY");
		} else
			dataMap.put("admin_add_message", "ADMIN COULD NOT BE DELETED");

		model.addAttribute("dataMap", dataMap);
		session.setAttribute("dataMap", dataMap);

		return "superAdminHome";
	}

	@RequestMapping(value = "/userLoginSubmit", method = RequestMethod.POST)
	public String loginModelAttribute(@ModelAttribute("loginForm") UserLogin user, Model model, HttpSession session,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "userLoginForm";
		} else {
			Map<String, Object> dataMap = userService.userLogin(user.getEmailId(), user.getPasswrd());
			model.addAttribute("dataMap", dataMap);
			System.out.println(dataMap.get("message"));

			if (dataMap.get("message") == null) {
				session.setAttribute("dataMap", dataMap);
				System.out.println(dataMap.get("role"));
				if (dataMap.get("role").equals("user"))
					return "userHome";
				else if (dataMap.get("role").equals("admin"))
					return "adminHome";
				else if (dataMap.get("role").equals("super_admin")) {
					return "superAdminHome";
				} else
					return "userLoginForm";
			} else {
				return "userLoginForm";
			}
		}

	}

	@RequestMapping(value = "/adminBack", method = RequestMethod.GET)
	public String adminbackbutton(Model model, HttpSession session) {
		Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
		model.addAttribute("dataMap", dataMap);
		return "superAdminHome";
	}

}

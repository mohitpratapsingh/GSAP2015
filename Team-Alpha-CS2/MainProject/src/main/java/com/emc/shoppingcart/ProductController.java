package com.emc.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.emc.shoppingcart.services.ProductService;
import com.emc.shoppingcart.services.UserService;
import com.emc.shoppingcart.utils.ConstantsClass;

@Controller
public class ProductController {

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/addProductForm", method = RequestMethod.GET)
	public String productForm(Model model, HttpSession session) {
		Product product = new Product();
		model.addAttribute("addProductForm", product);

		List<String> categoryList = new ArrayList<String>();
		categoryList.add("Electronics");
		categoryList.add("HomeAppliances");
		categoryList.add("Sports");
		categoryList.add("Books");
		model.addAttribute("categoryList", categoryList);
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("addProductForm") /* @Valid */ Product product, Model model,
			HttpSession session, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addProduct";
		} else {
			Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
			String response = productService.addProduct(product);

			List<User> userList = userService.getUsersByRoleId(ConstantsClass.USER_ID);
			dataMap.put("userList", userList);

			if (response.equals("SUCCESSFULL_UPDATE")) {
				List<Product> productList = productService.getProducts();
				dataMap.put("productList", productList);
				// dataMap.put("prod_add_message", response);
				model.addAttribute("prodMsg", response);
			} else {
				model.addAttribute("prodMsg", response);
				// dataMap.put("prod_add_message", response);
			}

			model.addAttribute("dataMap", dataMap);
			session.setAttribute("dataMap", dataMap);

			if (dataMap.get("role").equals("admin"))
				return "adminHome";
			else
				return "superAdminHome";
		}

	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("prodIductList") List<Integer> productIdList, Model model,
			HttpSession session) {

		String response = productService.removeMultipleProducts(productIdList);
		System.out.println(response);
		Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
		List<User> userList = userService.getUsersByRoleId(ConstantsClass.USER_ID);
		dataMap.put("userList", userList);
		List<Product> productList = productService.getProducts();
		dataMap.put("productList", productList);
		model.addAttribute("prodMsg", response);
		model.addAttribute("dataMap", dataMap);
		session.setAttribute("dataMap", dataMap);

		if (dataMap.get("role").equals("admin"))
			return "adminHome";
		else
			return "superAdminHome";

	}

	@RequestMapping(value = "/productBack", method = RequestMethod.GET)
	public String productbackbutton(Model model, HttpSession session) {
		Map<String, Object> dataMap = (Map<String, Object>) session.getAttribute("dataMap");
		model.addAttribute("dataMap", dataMap);
		if (dataMap.get("role").equals("admin"))
			return "adminHome";
		else
			return "superAdminHome";
	}

}

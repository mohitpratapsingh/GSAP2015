package com.emc.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.emc.shoppingcart.service.ProductService;
import com.emc.shoppingcart.service.UserService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	ProductService productService;

	@Autowired
	UserService listuser;

	@RequestMapping(value = "/ProductSubmit", method = RequestMethod.POST)
	public String productSave(@ModelAttribute("prodFormSubmit") @Valid Products product, BindingResult Result,
			Model model, HttpServletRequest request) {
		// ModelAndView model = new ModelAndView("AdminLanding");
		if (Result.hasErrors()) {
			return "AdminLanding";
		}
		try {
			String errMessage = "Error in saving product";
			String prodSaveInfo = productService.addProduct(product);
			if (prodSaveInfo.equals(null)) {
				model.addAttribute("message", errMessage);
			} else {
				model.addAttribute("message", prodSaveInfo);
			}
			System.out.println("Email:" + request.getParameter("session"));
			String emailId = request.getParameter("session");
			User user1 = listuser.getSpecificUserAccount(emailId);
			model.addAttribute("Name", listuser.findNameByEmailId(user1.getEmailId()));

			List<Products> allProduct = new ArrayList<Products>();
			allProduct = productService.findAllProducts();
			model.addAttribute("Productlist", allProduct);

			List<User> alluser = new ArrayList<User>();
			alluser = listuser.findAllUserAccounts();
			model.addAttribute("UserList", alluser);

			List<User> alladmin = new ArrayList<User>();
			alladmin = listuser.findAllAdmins();
			model.addAttribute("AdminList", alladmin);

			return "AdminLanding";
		} catch (Exception e) {
			String error = "Error in saving PRODUCT";
			model.addAttribute("error", error);
			return "AdminLanding";

		}

	}

	@RequestMapping(value = "/productDeleteSubmit", method = RequestMethod.POST)
	public String productDelete(@ModelAttribute("productDeleteForm") @Valid Products product, BindingResult Result,
			Model model, HttpServletRequest request) {
		try {

			String errMessage = "Error in deleting product";

			List<Products> allProduct = new ArrayList<Products>();
			allProduct = productService.findAllProducts();

			String[] prodDeleteInfo = new String[allProduct.size()];
			int count = 0;
			String[] prodval = request.getParameterValues("prodList");

			for (Products prod : allProduct) {
				for (String prodVal : prodval) {
					System.out.println("ProdVal" + prodVal);
					if (prod.getProdId() == Integer.parseInt(prodVal)) {
						System.out.println("Inside this :)");
						prodDeleteInfo[count++] = productService.deleteProduct(prod);
						break;
					}
				}
			}

			System.out.println("Email:" + request.getParameter("session"));
			String emailId = request.getParameter("session");
			User user1 = listuser.getSpecificUserAccount(emailId);
			model.addAttribute("Name", listuser.findNameByEmailId(user1.getEmailId()));

			allProduct = new ArrayList<Products>();
			allProduct = productService.findAllProducts();
			model.addAttribute("Productlist", allProduct);

			List<User> alluser = new ArrayList<User>();
			alluser = listuser.findAllUserAccounts();
			model.addAttribute("UserList", alluser);

			List<User> alladmin = new ArrayList<User>();
			alladmin = listuser.findAllAdmins();
			model.addAttribute("AdminList", alladmin);

			return "AdminLanding";
		} catch (Exception e) {
			e.printStackTrace();
			String error = "Error in deleting PRODUCT";
			model.addAttribute("error", error);
			return "AdminLanding";

		}
	}

}

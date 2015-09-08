package com.emc.shoppingcartfinal;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.emc.shoppingcartfinal.dao.ProductDao;
import com.emc.shoppingcartfinal.dao.ProductDaoImpl;
import com.emc.shoppingcartfinal.dao.UserDao;
import com.emc.shoppingcartfinal.model.DeleteProduct;
import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;
import com.emc.shoppingcartfinal.services.CreateServices;
import com.emc.shoppingcartfinal.services.CreateServicesImpl;
import com.emc.shoppingcartfinal.services.LoginServices;
import com.emc.shoppingcartfinal.services.LoginServicesIMPL;

@Controller
@RequestMapping(value = "/")
public class ShoppingCartController {

	@Autowired
	LoginServices loginuser;
	@Autowired
	UserDao userdao;
	@Autowired
	LoginServices login;
	@Autowired
	CreateServices serv;
	@Autowired
	ProductDao product;

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Model model) {
		User userLoginDetails = new User();
		model.addAttribute("userLogin", userLoginDetails);
		/*List<User> CrunchifyList = new ArrayList<User>();
		CrunchifyList = oi.GetAllUser(2);
		for (User user : CrunchifyList) {
			System.out.println(user.getFname());
		}*/

		// Product prod=new Product(1,"gam",1,12,522,"gamer prod");
		// product.insertProduct(prod);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "userLogin") User user, Model model, HttpSession session) {

		User user1;
		User user2;
		// user1=loginuser.Login(user.getEmailId(), user.getPassword());*/
		// user1=ui.getUserByEmailId("admin1");
		// User user2=new User("anshul", "kalra", "anshul@gmail.com",
		// "bangalore", "", "bangalore", "karnataka", "India", 8123, "admin",2);

		Map<String, Object> mapuser = new HashMap();
		mapuser = login.Login(user.getEmailId(), user.getPassword());
		user1 = (User) mapuser.get("SuperAdmin");
		user2 = (User) mapuser.get("User");
		if (user1 != null) {
			model.addAttribute("User", user1);
			session.setAttribute("userInfo1", user1);
			List<Product> allProduct = new ArrayList<Product>();
			allProduct = login.GetAllProduct();
			model.addAttribute("Productlist", allProduct);
			List<User> allUser = new ArrayList<User>();
			allUser = login.GetAllUser(2);
			model.addAttribute("Userlist", allUser);
			List<User> allAdmin = new ArrayList<User>();
			allAdmin = login.GetAllUser(1);
			model.addAttribute("Adminlist", allAdmin);
			model.addAttribute("selectedProduct",new DeleteProduct());
			return "Superuser";
		} else if (user2 != null) {
			model.addAttribute("User", user2);
			session.setAttribute("userInfo", user2);
			List<Product> allProduct = new ArrayList<Product>();
			allProduct = login.GetAllProduct();
			model.addAttribute("Productlist", allProduct);
			for (Product p : allProduct) {
				System.out.println(p.getpName());
			}
			return "user";

		} else {
			Exception e;
			e = (Exception) mapuser.get("ErrorMessage");
			System.out.println(e.getMessage());
			model.addAttribute("errorMessage", e.getMessage());
			return "login";
		}

	}

	@RequestMapping(value = "/registration1", method = RequestMethod.POST)
	public String Registration(@ModelAttribute(value = "registerUser") User user, Model model) {

		// System.out.println(user.getFname());
		return "registration";

	}

	@RequestMapping(value = "/registration2", method = RequestMethod.POST)
	public String RegistrationUser(@Valid @ModelAttribute(value = "registerUser") User user,BindingResult result, Model model) {
		if(result.hasErrors()){
			 return "registration";
		 }
		user.setRoleID(2);
		//serv.UserRegistration(user);
		int i;
		i=serv.UserRegistration(user);
		System.out.println(i);
		if(i==0)
		{
			model.addAttribute("Message", "Unable to register user");
		}
		else
		{
			model.addAttribute("Message", "User Registered Succesfully");
		}
		User userLoginDetails = new User();
		model.addAttribute("userLogin", userLoginDetails);
		return "login";
 
	}

	@RequestMapping(value = "/userinfo", method = RequestMethod.GET)
	public String MyProfile(Model model, HttpSession session) {
		User userInfo = (User)session.getAttribute("userInfo");
		model.addAttribute("UserProf",userInfo);
//		model.addAttribute("UserProf", user);
		System.out.println(userInfo.getFname());
		return "MyProfileUser";

	}

	@RequestMapping(value = "/registerProd1", method = RequestMethod.POST)
	public String RegisterProd(@ModelAttribute(value = "registerProd") Product prod, Model model) {

		// System.out.println(user.getFname());
		return "NewProduct";

	}

	@RequestMapping(value = "/registerProd2", method = RequestMethod.POST)
	public String Registrationprod(@ModelAttribute(value = "registerProd") Product Prod, Model model,HttpSession session) {
		//product.insertProduct(Prod);
		boolean registered;
		registered=serv.ProductRegistration(Prod);
		if(registered)
		{
			model.addAttribute("Message", "Product Registered succesfully");
		}
		else
		{
			model.addAttribute("Message", "Unable to register product");
		}
		User User = (User)session.getAttribute("userInfo1");
		List<User> allUser = new ArrayList<User>();
		allUser = login.GetAllUser(2);
		model.addAttribute("Userlist", allUser);
		List<Product> allProduct = new ArrayList<Product>();
		allProduct = login.GetAllProduct();
		model.addAttribute("Productlist", allProduct);
		model.addAttribute("selectedProduct",new DeleteProduct());
		List<User> allAdmin = new ArrayList<User>();
		allAdmin = login.GetAllUser(1);
		model.addAttribute("Adminlist", allAdmin);
		return "Superuser";
	}

	@RequestMapping(value = "/registerAdmin1", method = RequestMethod.POST)
	public String RegisterAdmin(@ModelAttribute(value = "registerAdmin") User user, Model model) {

		// System.out.println(user.getFname());
		return "NewAdmin";

	}

	@RequestMapping(value = "/registerAdmin2", method = RequestMethod.POST)
	public String RegistrationAdmin(@ModelAttribute(value = "registerProd") User user, Model model) {
		user.setRoleID(1);
		serv.UserRegistration(user);
		return "NewAdmin";

	}
	@RequestMapping(value = "/Superuser", method = RequestMethod.POST)
	public String productDelete(@ModelAttribute(value = "selectedProduct") DeleteProduct prod, Model model) {
		
		
		boolean prodDeleted;
		prodDeleted=serv.ProductDelete(prod.getProductIds());
		if(!prodDeleted)
		{
			model.addAttribute("Message", "Product not deleted");
		}
		//product.deleteProduct(prod.getProductIds());
		List<Product> allProduct = new ArrayList<Product>();
		allProduct = login.GetAllProduct();
		model.addAttribute("Productlist", allProduct);
		List<User> allUser = new ArrayList<User>();
		allUser = login.GetAllUser(2);
		model.addAttribute("Userlist", allUser);
		List<User> allAdmin = new ArrayList<User>();
		allAdmin = login.GetAllUser(1);
		model.addAttribute("Adminlist", allAdmin);
		System.out.println("Inside productDelete"+prod.getProductIds());
		return "Superuser";

	}
	
}

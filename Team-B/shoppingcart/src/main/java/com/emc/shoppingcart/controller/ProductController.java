package com.emc.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.ModelAndView;

import com.emc.shopping.model.Products;
import com.emc.shopping.model.User;
import com.emc.shopping.model.UserLogin;
import com.emc.shoppingcart.service.ProductService;
import com.emc.shoppingcart.service.UserLoginServiceImpl;
import com.emc.shoppingcart.service.UserService;

//import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;
	
	
	//OLD WAY OF DOING THINGS BUT CORRECT CODE
/*	@RequestMapping(value = "/productUpdateSubmit", method = RequestMethod.POST)
	public ModelAndView productUpdate(@ModelAttribute("productForm") @Valid Products product,BindingResult Result) {
		ModelAndView model = new ModelAndView("AdminLanding");
		String errMessage = "Error in retriving list of products";
		
		
		if(Result.hasErrors()) {
			return model;
		}
		String prodUpdateInfo = productService.updateProduct(product);
		if(prodUpdateInfo.equals(null)) {
			model.addObject("message",errMessage);
		}
		else {
		model.addObject("message",prodUpdateInfo);
		
		}
		return model;
		
	}*/
	
	
	/*@RequestMapping(value = "/productUpdateSubmit", method = RequestMethod.POST)
	public String productUpdate(@ModelAttribute("productForm") @Valid Products product,BindingResult Result,Model model) {
		//ModelAndView model = new ModelAndView("AdminLanding");
		String errMessage = "Error in retriving list of products";
		
		String prodUpdateInfo = productService.updateProduct(product);
		if(Result.hasErrors()) {
			return "AdminLanding";
		}
		
		else if(prodUpdateInfo.equals(null)) {
			
			model.addAttribute("message",errMessage);
		}
		else {
			model.addAttribute("message",prodUpdateInfo);
		
		}
		//return model;
		return "AdminLanding";
		
	}*/
	/*
	*/
	/**
	 * 
	 * @param Result
	 * @return
	 *//*
	@RequestMapping(value = "/showProductsSubmit", method = RequestMethod.GET) 
	public String showProductList(BindingResult Result,Model model) {
		if(Result.hasErrors()) {
			return "AdminLanding";
		}
		try{
			List<Products> prodList = productService.findAllProducts();
			model.addAttribute("lists", prodList);
			return "AdminLanding";
		}
		catch(Exception e){
			String error="Error in saving admin";
			model.addAttribute("error",error);	
    	}
    	finally{
    		return "AdminLanding";
    	}
	}*/
	
	@RequestMapping(value = "/ProductSubmit", method = RequestMethod.POST)
	public String productSave(@ModelAttribute("prodFormSubmit") @Valid Products product,BindingResult Result,Model model,HttpServletRequest request) {
		//ModelAndView model = new ModelAndView("AdminLanding");
		if(Result.hasErrors()) {
			return "AdminLanding";
		}
		try{
			String errMessage = "Error in saving product";	
			String prodSaveInfo = productService.addProduct(product);
			if(prodSaveInfo.equals(null)) {
				model.addAttribute("message",errMessage);
			}
			else {
				model.addAttribute("message",prodSaveInfo);
			}
			System.out.println("Email:"+request.getParameter("session"));
			String emailId=request.getParameter("session");
			User user1=userService.getSpecificUserAccount(emailId);
			model.addAttribute("Name", userService.findNameByEmailId(user1.getEmailId()));
			
			 List<Products> allProduct = new ArrayList<Products>();
			 allProduct=productService.findAllProducts();
			 model.addAttribute("Productlist", allProduct); 
			 
	
			 List<User> alluser = new ArrayList<User>();
			 alluser=userService.findAllUserAccounts();
			 model.addAttribute("UserList", alluser);
			
			
			 List<User> alladmin = new ArrayList<User>();
			 alladmin=userService.findAllAdmins();
			 model.addAttribute("AdminList", alladmin);
	        
			return "AdminLanding";
		}
		catch(Exception e){
			String error="Error in saving PRODUCT";
			model.addAttribute("error",error);	
			return "AdminLanding";
	    	
		}
    			
	}
	
	
	@RequestMapping(value = "/productDeleteSubmit", method = RequestMethod.POST)
	public String productDelete(@ModelAttribute("productDeleteForm") @Valid Products product,BindingResult Result,Model model,HttpServletRequest request) {
		try{
			
			String errMessage = "Error in deleting product";

			 List<Products> allProduct = new ArrayList<Products>();
			 allProduct=productService.findAllProducts();
			
			String[] prodDeleteInfo = new String[allProduct.size()];
			int count=0;
			String[] prodval=request.getParameterValues("prodList");
			
			for(Products prod:allProduct){
				for(String prodVal:prodval){
					System.out.println("ProdVal"+prodVal);
					if(prod.getProdId()==Integer.parseInt(prodVal)){
						System.out.println("Inside this :)");
						prodDeleteInfo[count++] = productService.deleteProduct(prod);
						break;
						}
					}
			}
			/*
			for(String msg:prodDeleteInfo){
				if(msg==null)
					model.addAttribute("error",errMessage);
			}
			*/
			System.out.println("Email:"+request.getParameter("session"));
			String emailId=request.getParameter("session");
			User user1=userService.getSpecificUserAccount(emailId);
			model.addAttribute("Name", userService.findNameByEmailId(user1.getEmailId()));
			
			 allProduct = new ArrayList<Products>();
			 allProduct=productService.findAllProducts();
			 model.addAttribute("Productlist", allProduct); 
			 
	
			 List<User> alluser = new ArrayList<User>();
			 alluser=userService.findAllUserAccounts();
			 model.addAttribute("UserList", alluser);
			
			
			 List<User> alladmin = new ArrayList<User>();
			 alladmin=userService.findAllAdmins();
			 model.addAttribute("AdminList", alladmin);
	        
			return "AdminLanding";
		}
		catch(Exception e){
			e.printStackTrace();
			String error="Error in deleting PRODUCT";
			model.addAttribute("error",error);	
			return "AdminLanding";
			
		}
    }
	
	
	
}

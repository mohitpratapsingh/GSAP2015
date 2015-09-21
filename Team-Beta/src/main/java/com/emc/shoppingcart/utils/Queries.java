package com.emc.shoppingcart.utils;

import org.springframework.beans.factory.annotation.Value;

public class Queries {
	
	@Value("${product.get.all}")
	public   String getAllproducts;

}

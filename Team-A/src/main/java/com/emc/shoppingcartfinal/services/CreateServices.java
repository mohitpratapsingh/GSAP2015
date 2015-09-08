package com.emc.shoppingcartfinal.services;

import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;

public interface CreateServices {
	
        public int UserRegistration(User user);
        public boolean ProductRegistration(Product prod);
        public boolean ProductDelete(int[] pIds);

}

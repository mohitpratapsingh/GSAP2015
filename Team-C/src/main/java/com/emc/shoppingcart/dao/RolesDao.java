package com.emc.shoppingcart.dao;

import com.emc.shoppingcart.model.Roles;

public interface RolesDao {
public Roles getRole(int rId);
public boolean insertRole(Roles role);
}

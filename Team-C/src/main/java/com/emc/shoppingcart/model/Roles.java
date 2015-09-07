package com.emc.shoppingcart.model;

import java.io.Serializable;

public class Roles implements Serializable {
	private long rId;
	private String rName;

	public Roles() {

	}

	public long getrId() {
		return rId;
	}

	public void setrId(long rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

}

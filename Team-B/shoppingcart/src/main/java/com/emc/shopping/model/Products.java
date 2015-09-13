package com.emc.shopping.model;

import java.io.Serializable;

public class Products implements Serializable {

	private static final long serialVersionUID = 4321144132413243L;

	private long prodId;
	private String prodName;

	private float price;
	private int quantity;

	public Products() {

	}

	public Products(String prodName, float price, int quantity) {
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

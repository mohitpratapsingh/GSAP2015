package com.emc.shoppingcartfinal.model;

import java.io.Serializable;

public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int pId;
	private String pName;
	private int depID;
	private int quantity;
	private int price;
	private String prodDes;
	
	public Product() {
		super();
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getDepID() {
		return depID;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public void setDepID(int depID) {
		this.depID = depID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdDes() {
		return prodDes;
	}
	public void setProdDes(String prodDes) {
		this.prodDes = prodDes;
	}
	public Product(int pId, String pName, int depID, int quantity, int price, String prodDes) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.depID = depID;
		this.quantity = quantity;
		this.price = price;
		this.prodDes = prodDes;
	}
	
	
	

}

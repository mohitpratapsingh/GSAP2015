package com.emc.shoppingcart.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private long pId;
	@NotEmpty
	private String pName;
	@NotEmpty
	private Float price;
	@NotEmpty
	private String category;
	@NotEmpty
	private String imageName;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pName, Float price, String category, String imageName) {

		this.pName = pName;
		this.price = price;
		this.category = category;
		this.imageName = imageName;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}

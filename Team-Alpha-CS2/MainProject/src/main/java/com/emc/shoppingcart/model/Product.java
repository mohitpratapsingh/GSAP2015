package com.emc.shoppingcart.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@NotEmpty
	@Field(value = "name")
	private String pName;
	@NotEmpty
	@Field(value = "category")
	private String category;
	@NotEmpty
	@Field(value = "price")
	private Float price;
	@NotEmpty
	@Field(value = "brand")
	private String brand;
	@NotEmpty
	@Field(value = "quantity")
	private int quantity;
	@NotEmpty
	@Field(value = "description")
	private String description;
	
	public Product(long id, String pName, String category, Float price, String brand, int quantity,
			String description) {
		super();
		this.id = id;
		this.pName = pName;
		this.category = category;
		this.price = price;
		this.brand = brand;
		this.quantity = quantity;
		this.description = description;
	}

	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}

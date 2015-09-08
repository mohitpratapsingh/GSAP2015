package com.emc.shoppingcartfinal.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	//private String userID;
	@Size(min =4,max=20,message="4 - 20 characters")
	private String fname;
	private String lname;
	@NotNull(message="Mail needs to be filled")
	@Size(min =4,max=20,message="4 - 20 characters")
	private String emailId;
	@Size(min =4,max=20,message="Min 6 characters requried")
	private String addressLine1;
	private String addressLine2;
	@Size(min =1,max=20,message="City can't be empty")
	private String city;
	@Size(min =1,max=20,message="State can't be empty")
	private String state;
	@Size(min =1,max=20,message="Country can't be empty")
	private String country;
	//@Size(min =1,max=10,message="Pincode can't be empty")
	private int pincode;
	@Size(min =4,max=20,message="Password needs to be atlest 5 alphanumerics")
	private String password;
	private int roleID;
	

	public User() {
		
	}
	public User(String fname, String lname, String emailId, String addressLine1, String addressLine2, String city,
			String state, String country, int pincode, String password, int roleID) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.password = password;
		this.roleID = roleID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	
	

}

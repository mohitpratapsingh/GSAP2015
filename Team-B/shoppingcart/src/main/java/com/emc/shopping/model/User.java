package com.emc.shopping.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


//This is the model class for the Registration 

public class User implements Serializable {

	private static final long serialVersionUID = 8487279839813243L;

	@NotNull
	private long userId;

	@NotEmpty
	private String firstName;

	private String lastName;

	@NotEmpty
	@Email
	private String emailId;

	@NotEmpty
	@Size(min = 4, max = 25)
	private String password;

	@NotNull
	private int roleId;

	@NotEmpty
	private String address;

	public User() {

	}

	public User(String firstName, String lastName, String emailId, String password, int roleId, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return "No such user";
	 */

}

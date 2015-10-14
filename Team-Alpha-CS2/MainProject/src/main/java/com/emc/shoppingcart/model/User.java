package com.emc.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "u_id", nullable = false)
	private long uId;

	@Column(name = "gender", nullable = true)
	private String gender;


	@Size(min = 2, max = 30)
	@Column(name = "user_fname", nullable = true, length = 30)
	private String userFname;

	@Size(min = 2, max = 30)
	@Column(name = "user_lname", nullable = true, length = 30)
	private String userLname;

	@NotEmpty
	@Email
	@Column(name = "email_id", nullable = false, length = 80)

	private String emailId;

	@Size(min = 8, max = 12)
	@Column(name = "passwrd", nullable = false, length = 12)
	private String passwrd;

	@Size(min = 5, max = 40)
	@Column(name = "address_line1", nullable = true, length = 200)
	private String addressLine1;

	@Column(name = "address_line2", nullable = true, length = 200)
	private String addressLine2;

	// @Size(min=10,max=10)
	@Column(name = "phone_number", nullable = true)
	private Long phoneNumber;


	@ManyToOne
	@JoinColumn( name="r_id")
	private Roles role;
	


	public User(String gender, String userFname, String userLname, String emailId, String passwrd, String addressLine1,
			String addressLine2, Long phoneNumber) {
		super();
		this.gender = gender;
		this.userFname = userFname;
		this.userLname = userLname;
		this.emailId = emailId;
		this.passwrd = passwrd;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.phoneNumber = phoneNumber;

	}


	public Roles getRole() {
		return role;
	}



	public void setRole(Roles role) {
		this.role = role;
	}


	public User() {

	}

	public long getuId() {
		return uId;
	}

	public void setuId(long uId) {
		this.uId = uId;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

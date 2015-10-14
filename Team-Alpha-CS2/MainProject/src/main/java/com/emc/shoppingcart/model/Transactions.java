package com.emc.shoppingcart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private long trascationId;
	@Column(name = "user_id ")
	private long userId;
	@Column(name = "time_stamp")
	private Date timeStamp;
	@Column(name = "status")
	private String status;
	@Column(name = "total_amount")
	private long totalAmount;

	// @JoinColumn ( name = "transaction_id")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction")
	private Set<Orders> order = new HashSet<Orders>(0);

	public Transactions() {

	}

	public Transactions(long userId, Date timeStamp, String status, long totalAmount) {
		super();
		this.userId = userId;
		this.timeStamp = timeStamp;
		this.status = status;
		this.totalAmount = totalAmount;
	}

	public long getTrascationId() {
		return trascationId;
	}

	public void setTrascationId(long trascationId) {
		this.trascationId = trascationId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<Orders> getProducts() {
		return order;
	}

	public void setProducts(Set<Orders> products) {
		this.order = products;
	}

}

package com.emc.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {

	@Id
	@GeneratedValue
	@Column(name="transaction_id")
	private long trascationId;
	@Column(name="user_id ")
	private long userId;
	@Column(name="time_stamp")
	private long timeStamp;
	@Column(name="status")
	private long status;
	@Column(name="total_amount")
	private long totalAmount;
	
	public Transactions(long userId, long timeStamp, long status, long totalAmount) {
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
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}

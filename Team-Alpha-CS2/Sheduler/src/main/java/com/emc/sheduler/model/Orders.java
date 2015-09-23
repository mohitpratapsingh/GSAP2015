package com.emc.sheduler.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "orders" )
public class Orders {
	
	public Orders() {
		
	}
	
	@Id
	@GeneratedValue
    @Column ( name = "order_id" )		
	private int orderId;
	
	@ManyToOne
	@JoinColumn ( name = "transaction_id")
	private Transactions transaction;
	
	@Column (name = "p_id" )
	private int pId;
	
	@Column (name = "quantity" )
	private int quantity;
	
	@Column (name = "price" )
	private float price;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Transactions getTransactionId() {
		return transaction;
	}

	public void setTransactionId(Transactions transaction) {
		this.transaction = transaction;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	

	public Orders(Transactions transaction, int pId, int quantity, float price) {
		super();
		this.transaction = transaction;
		this.pId = pId;
		this.quantity = quantity;
		this.price = price;
	}

	
	

}

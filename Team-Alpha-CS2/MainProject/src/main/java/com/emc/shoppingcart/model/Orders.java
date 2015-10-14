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


@Entity
@Table( name = "orders" )
public class Orders implements Serializable{
	
	@Id
	@GeneratedValue
    @Column ( name = "order_id" )		
	private int orderId;
	
	@ManyToOne
	@JoinColumn ( name = "transaction_id")
	private Transactions transaction;
	
	@Column (name = "p_id" )
	private Long pId;
	
	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
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

	@Column (name = "quantity" )
	private int quantity;
	
	@Column (name = "price" )
	private float price;

	

	public Orders() {
		
	}


	public Orders(Long pId, int quantity, float price,Transactions tr) {
		super();
		this.transaction=tr;
		this.pId = pId;
		this.quantity = quantity;
		this.price = price;
	}

}

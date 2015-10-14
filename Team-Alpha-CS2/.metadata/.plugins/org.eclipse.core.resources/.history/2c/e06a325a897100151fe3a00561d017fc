package com.emc.shoppingcart.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="roles")
public class Roles implements Serializable {
	@Id
	@Column(name = "r_id", nullable = false)
	private long rId;
	
	@Column(name = "r_name", nullable = false, length = 30)
	private String rName;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "role")
	private Set<User> users=new HashSet<User>(0);

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Roles() {

	}

	public long getrId() {
		return rId;
	}

	public void setrId(long rId) {
		this.rId = rId;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

}

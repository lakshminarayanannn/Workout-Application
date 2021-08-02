package com.personalworkouttracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String role_name;

	public Role() {
		super();
	}

	public Role(String role_name) {
		super();

		this.role_name = role_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + "]";
	}

}

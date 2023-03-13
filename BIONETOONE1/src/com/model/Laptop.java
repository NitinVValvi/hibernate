package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private int l_id;
	private String laptop_name;
	@OneToOne (cascade = CascadeType.ALL)
	private Employee e;
	public int getL_id() {
		return l_id;
	}
	public void setL_id(int l_id) {
		this.l_id = l_id;
	}
	public String getLaptop_name() {
		return laptop_name;
	}
	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}
	public Employee getE() {
		return e;
	}
	public void setE(Employee e) {
		this.e = e;
	}
}
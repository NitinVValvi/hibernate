package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	private int emp_id;
	private String emp_name;
	@OneToOne (cascade = CascadeType.ALL ,mappedBy= "e")
	private AadharCard a;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public AadharCard getA() {
		return a;
	}
	public void setL(AadharCard a) {
		this.a = a;
	}

}

package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
@Id
private int emp_id;
private String empname;
@ManyToOne (cascade = CascadeType.ALL)
private Department d;

public int getEmp_id() {
	return emp_id;
}

public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}

public String getEmpname() {
	return empname;
}

public void setEmpname(String empname) {
	this.empname = empname;
}

public Department getD() {
	return d;
}

public void setD(Department d) {
	this.d = d;
}

}

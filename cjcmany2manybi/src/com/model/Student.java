package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student {
 @Id
	private int s_id;
 private String s_name;
 @ManyToMany (cascade = CascadeType.ALL,mappedBy = "student")
 private Set<Staff> staff = new HashSet<>();
 public Set<Staff> getStaff() {
	return staff;
}
public void setStaff(Set<Staff> staff) {
	this.staff = staff;
}
@ManyToOne (cascade = CascadeType.ALL)
 private CJC cjc;
public CJC getCjc() {
	return cjc;
}
public void setCjc(CJC cjc) {
	this.cjc = cjc;
}
public int getS_id() {
	return s_id;
}
public void setS_id(int s_id) {
	this.s_id = s_id;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
}

}

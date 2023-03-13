package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CJC {
	@Id
	@GeneratedValue
	@Column (name = "cjc_PK")

	private int cjc_id;
	private String addr;
	@OneToMany (targetEntity = Staff.class, cascade = CascadeType.ALL,mappedBy = "cjc")
	Set<Staff> staff = new HashSet<>();

	@OneToMany (targetEntity = Student.class, cascade = CascadeType.ALL,mappedBy = "cjc")
	Set<Student> student = new HashSet<>();

	public int getCjc_id() {
		return cjc_id;
	}

	public void setCjc_id(int cjc_id) {
		this.cjc_id = cjc_id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
}

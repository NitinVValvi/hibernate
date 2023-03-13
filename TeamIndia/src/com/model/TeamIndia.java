package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

//@Entity

//@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public class TeamIndia {
	@Id
	private String firstname;
	private String lastname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}

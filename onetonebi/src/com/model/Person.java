package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	//@GeneratedValue
	
	private int personId;
	private String personName;
	@OneToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn (name = "pDetail_FK")
	private PersonDetail pDetail;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public PersonDetail getpDetail() {
		return pDetail;
	}
	public void setpDetail(PersonDetail pDetail) {
		this.pDetail = pDetail;
	}
	
}

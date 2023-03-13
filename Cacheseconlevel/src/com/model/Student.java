package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
@Cache (usage = CacheConcurrencyStrategy.READ_WRITE)
public class Student {
	@Id
	private int rollno;
	private String name;
	private String addr;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

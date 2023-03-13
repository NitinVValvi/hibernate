package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int sid;
	private String sname;
	private String addr;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Studentid : " + getSid() + "\nStudent Name:" + getSname() + "\nStudent Address:" + getAddr();
	}
	
}

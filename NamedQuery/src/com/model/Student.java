package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery (name = "Update", query = "update Student s set sname= ?,addr = ? where s.sid = ?"),
	@NamedQuery (name = "Update1", query = "update Student s set addr= ? where s.sid = ?"),
	@NamedQuery (name ="findAll" , query = "from Student"),
	@NamedQuery (name = "Delete", query = "delete from Student s where s.sid =:id")
})
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
		return "Student Id" + getSid() + "\nStudent Name" + getSname() + "\nStudent Address" + getAddr();
	}
}

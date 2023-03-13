package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BackupStudent {
@Id
private int sid;
private String sname;
private String addr;
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
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
}

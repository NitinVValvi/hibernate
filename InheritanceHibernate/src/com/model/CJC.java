package com.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

public class CJC {
@Id
private int id;
private String name;
private String cname;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

}

package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Staff {
	@Id
	private int st_id;
	private String st_name;
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	
}

package com.model;

import javax.persistence.Entity;



@Entity
public class ChecqueType extends Payment {
	
	private int checkno;
	private String checquetype;
	public int getCheckno() {
		return checkno;
	}
	public void setCheckno(int checkno) {
		this.checkno = checkno;
	}
	public String getChecquetype() {
		return checquetype;
	}
	public void setChecquetype(String checquetype) {
		this.checquetype = checquetype;
	}
	
	
}

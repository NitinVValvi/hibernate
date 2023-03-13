package com.model;

import javax.persistence.Entity;

@Entity
public class Akurdi extends CJC
{
	private String weekend;

	public String getWeekend() {
		return weekend;
	}

	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	
	
}

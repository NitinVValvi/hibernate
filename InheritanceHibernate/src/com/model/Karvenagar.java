package com.model;

import javax.persistence.Entity;

@Entity
public class Karvenagar extends CJC 
{
	private String regular;

	public String getRegular() {
		return regular;
	}

	public void setRegular(String regular) {
		this.regular = regular;
	}
}

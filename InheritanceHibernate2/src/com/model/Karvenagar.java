package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("cjckarvengarregular")
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

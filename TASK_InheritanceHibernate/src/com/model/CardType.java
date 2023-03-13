package com.model;

import javax.persistence.Entity;

@Entity
public class CardType extends Payment{
	private long cardno;
	private String cardtype;
	public long getCardno() {
		return cardno;
	}
	public void setCardno(long cardno) {
		this.cardno = cardno;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	
}

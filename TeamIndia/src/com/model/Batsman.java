package com.model;

import javax.persistence.Entity;

@Entity
public class Batsman extends TeamIndia{
	private String battinghand;
	private int highestscore;
	public String getBattinghand() {
		return battinghand;
	}
	public void setBattinghand(String battinghand) {
		this.battinghand = battinghand;
	}
	public int getHighestscore() {
		return highestscore;
	}
	public void setHighestscore(int highestscore) {
		this.highestscore = highestscore;
	}
	
	
}

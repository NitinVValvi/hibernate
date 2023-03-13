package com.model;

import javax.persistence.Entity;

@Entity
public class Bowler extends TeamIndia{
	private String bowlinghand;
	private int  highestgoal;
	public String getBowlinghand() {
		return bowlinghand;
	}
	public void setBowlinghand(String bowlinghand) {
		this.bowlinghand = bowlinghand;
	}
	public int getHighestgoal() {
		return highestgoal;
	}
	public void setHighestgoal(int highestgoal) {
		this.highestgoal = highestgoal;
	}
}

package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Batsman;
import com.model.Bowler;
import com.model.TeamIndia;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		/*
		 * TeamIndia t = new TeamIndia(); t.setFirstname("Sachin");
		 * t.setLastname("Tendulkar");
		 */
		Batsman b = new Batsman();
		b.setFirstname("Sachin");
		b.setLastname("Tendulkar");
		b.setBattinghand("Right Hand");
		b.setHighestscore(200);
		Bowler bo = new Bowler();
		bo.setFirstname("Jasprit");
		bo.setLastname("Bumrah");
		bo.setBowlinghand("Right Hand");
		bo.setHighestgoal(5);
		
		//session.save(t);
		session.save(b);
		session.save(bo);
		
		session.beginTransaction().commit();
		
	}
}

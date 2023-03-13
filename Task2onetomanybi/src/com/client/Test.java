package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Simcard;
import com.model.Mobile;

public class Test {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Mobile mobile = new Mobile();
	mobile.setMid(11);
	mobile.setMname("samsung");
	Simcard s1 = new Simcard();
	s1.setSid(1);
	s1.setSname("vodafone");
	s1.setT(mobile);
	Simcard s2 = new Simcard();
	s2.setSid(2);
	s2.setSname("airtel");
	s2.setT(mobile);
	
	
	mobile.getSim().add(s1);
	mobile.getSim().add(s2);
	session.save(mobile);
	session.beginTransaction().commit();
}
}

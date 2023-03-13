package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Akurdi;
import com.model.Karvenagar;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Akurdi a = new Akurdi();
		a.setId(1);
		a.setName("ABC");
		a.setCname("CJC");
		a.setWeekend("weekendbatch");
		
		
		Karvenagar k = new Karvenagar();
		k.setId(2);
		k.setName("XYZ");
		k.setCname("CJC");
		k.setRegular("regularbatch");
		session.save(a);
		session.save(k);
		session.beginTransaction().commit();
	}	
}

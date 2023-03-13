package com.client;

import com.config.HibernateUtil;
import com.model.Akurdi;
import com.model.CJC;
import com.model.Karvenagar;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CJC cjc = new CJC();
		cjc.setId(1);
		cjc.setName("ABC");
		cjc.setCname("CJC");
		
		
		Akurdi a = new Akurdi();
		a.setId(101);
		a.setName("abc");
		a.setCname("CJC");
		a.setWeekend("weekend");
		
		Karvenagar k = new Karvenagar();
		k.setId(102);
		k.setName("xyz");
		k.setCname("CJC");
		k.setRegular("regular");
		
		
		session.save(cjc);
		session.save(a);
		session.save(k);
		session.beginTransaction().commit();
	}
}

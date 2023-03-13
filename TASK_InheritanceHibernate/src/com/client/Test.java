package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.CardType;
import com.model.ChecqueType;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CardType ct = new CardType();
		ct.setCardno(121908249198l);
		ct.setAmount(10000);
		ct.setCardtype("VISA");
		ct.setPid(121313);
		
		ChecqueType cq = new ChecqueType();
		cq.setCheckno(12321);
		cq.setChecquetype("Draft");
		cq.setAmount(5000);
		cq.setPid(123241);
		session.save(ct);
		session.save(cq);
		
		session.beginTransaction().commit();
	}
}

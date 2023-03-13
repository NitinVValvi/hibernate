package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Person;
import com.model.PersonDetail;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		PersonDetail nitdetail = new PersonDetail();
		nitdetail.setPersonDetailId(123);
		nitdetail.setZipcode("411030");
		nitdetail.setJob("Developer");
		nitdetail.setIncome(60000.50);
		
		Person nit = new Person();
		nit.setPersonId(1);
		nit.setPersonName("NITIN VALVI");
		
		nit.setpDetail(nitdetail);
		
		session.save(nit);
		session.beginTransaction().commit(); 
		session.close();
	}
}
 
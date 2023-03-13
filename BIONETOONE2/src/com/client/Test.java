package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.AadharCard;
import com.model.Employee;


public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Employee e = new Employee();
		e.setEmp_id(11);
		e.setEmp_name("Nitin");
		
		AadharCard a = new AadharCard();
		a.setA_id(183592898);
		
		a.setA_name("Nitin");
		a.setE(e);
		
		session.save(a);
		session.save(e);
		
		session.beginTransaction().commit();
		session.close();
	}
}

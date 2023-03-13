package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Employee;
import com.model.Laptop;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Laptop l = new Laptop();
		l.setL_id(1);
		
		l.setLaptop_name("HP");
		
		Employee e = new Employee();
		e.setEmp_id(11);
		e.setEmp_name("Nitin");
		
		l.setE(e);
		
		session.save(l);
		
		session.beginTransaction().commit();
		session.close();
	}
}

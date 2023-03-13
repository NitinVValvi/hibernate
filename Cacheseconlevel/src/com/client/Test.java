package com.client;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;

import config.HibernateUtil;

public class Test {
public static void main(String[] args) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	Session session = sf.openSession();
	
	/*
	 * Student s = new Student(); s.setRollno(111); s.setName("Nitin");
	 * s.setAddr("Pune");
	 */
	
	
	  Student s = session.get(Student.class, 110);
	  System.out.println(s.getName());
	  Student s2 = session.get(Student.class, 110);
	  
	  
	
	 System.out.println(s2.getName());
	 
	 Session session2 = sf.openSession();
	 
	 Student s3 =  session2.get(Student.class, 110);
	 System.out.println(s3.getName());
	
	//System.out.println(s.getName());
	
	//session.save(s);
	
	session2.beginTransaction().commit();
	session.beginTransaction().commit();
}
}

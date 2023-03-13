package com.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Student;

public class Test {
	public static void main(String[] args) {
		//configuration object
		Configuration cfg = new Configuration();
		cfg.configure("com/config/hibernate.cfg.xml");
		
		//session factory object
		SessionFactory sf = cfg.buildSessionFactory();
		
		//open session
		Session session = sf.openSession();
		
		//transaction begin
		Transaction tx = session.beginTransaction();
		Student stu = new Student();
		//Student stu = session.get(Student.class, 1);
		//Student stu = session.load(Student.class, 2);
			
		 stu.setRollno(1);
		 stu.setName("Nitin");
		 stu.setAddress("Pune");
		  stu.setMob_no(8945629489l);
		 
		
		
		//System.out.println("Rollno: "+stu.getRollno());
		//System.out.println("Name: "+stu.getName());
		//System.out.println("Address: "+stu.getAddress());
		//session.delete(stu);
		
		/*
		 * System.out.println(stu.getRollno()); System.out.println(stu.getName());
		 */
		session.update(stu);
		//session.save(stu);
		tx.commit();
		session.close();
	}
}

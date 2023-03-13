package com.client;

import com.config.HibernateUtil;
import com.model.Course;
import com.model.Student;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Course java = new Course();
		java.setCid(101);
		java.setCname("java");
		Course python = new Course();
		python.setCid(102);
		python.setCname("python");
		
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Nitin");
		
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Akshay");
		
		s1.getC().add(java);
		s1.getC().add(python);
		java.getS().add(s1);
	
		s2.getC().add(python);
		python.getS().add(s2);
		
		session.save(java);
		session.save(python);
		
		session.beginTransaction().commit();
	}
}

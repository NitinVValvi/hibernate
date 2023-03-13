package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Course;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Nitin");
		
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Akshay");
		
		Course java = new Course();
		java.setCid(101);
		java.setCname("Java");
		
		Course python = new Course();
		python.setCid(102);
		python.setCname("Python");
		
		s1.getC().add(java);
		s1.getC().add(python);
		 
		s2.getC().add(python);
		session.save(s1);
		session.save(s2);
		
		session.beginTransaction().commit();
		
		
	}
}

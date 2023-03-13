package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Student;
import com.model.Teacher;

public class Test {
public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Teacher t = new Teacher();
	t.setTid(11);
	t.setTname("JAY");
	Student s1 = new Student();
	s1.setSid(1);
	s1.setSname("Nitin");
	s1.setT(t);
	Student s2 = new Student();
	s2.setSid(2);
	s2.setSname("Rahul");
	s2.setT(t);
	
	
	t.getS().add(s1);
	t.getS().add(s2);
	session.save(t);
	session.beginTransaction().commit();
}
}

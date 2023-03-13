package com.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Staff;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Nitin Valvi");
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Akshay Patil");
		
		
		
		
		Staff st1 = new Staff();
		st1.setSt_id(101);
		st1.setSt_name("Kunal Sir");
		Staff st2 = new Staff();
		st2.setSt_id(102);
		st2.setSt_name("Nandu Sir");
		
		
		st1.getS().add(s1);
		st1.getS().add(s2);
		s1.getSt().add(st1);
		s2.getSt().add(st1);
		
		st2.getS().add(s1);
		s1.getSt().add(st2);
		Set<Staff> staff = new HashSet<>();
		staff.add(st1);
		staff.add(st2);
		session.save(s1);
		session.save(s2);
		
		session.beginTransaction().commit();
	
		
	}
}

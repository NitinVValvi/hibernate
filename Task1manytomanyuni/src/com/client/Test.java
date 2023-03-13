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
		
		
		
		
		Staff staff1 = new Staff();
		staff1.setSt_id(101);
		staff1.setSt_name("Kunal Sir");
		Staff staff2 = new Staff();
		staff2.setSt_id(102);
		staff2.setSt_name("Nandu Sir");
		
		
		s1.getStaff().add(staff1);
		s1.getStaff().add(staff2);
		s2.getStaff().add(staff2);
		Set<Staff> staff = new HashSet<>();
		staff.add(staff1);
		staff.add(staff2);
		session.save(s1);
		session.save(s2);
		
		session.beginTransaction().commit();
		
		for (Staff st :staff ) {
			System.out.println(st.getSt_id());
			System.out.println(st.getSt_name());
		}
		
	}
}

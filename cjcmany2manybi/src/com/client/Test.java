package com.client;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.CJC;
import com.model.Staff;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CJC cjc = new CJC();
		cjc.setAddr("Karvenagar");
		
		Staff st1 = new Staff();
		st1.setSt_id(101);
		st1.setSt_name("Kunal Sir");
		st1.setCjc(cjc);
		
		Staff st2 = new Staff();
		st2.setSt_id(102);
		st2.setSt_name("Nandu Sir");
		st2.setCjc(cjc);
		
		Student s1 = new Student();
		s1.setS_id(1);
		s1.setS_name("Nitin Valvi");
		s1.setCjc(cjc);
		s1.getStaff().add(st1);
		s1.getStaff().add(st2);
		
		Student s2 = new Student();
		s2.setS_id(2);
		s2.setS_name("Akshay Patil");
		s2.setCjc(cjc);
		s2.getStaff().add(st2);

		
		st1.getStudent().add(s1);
		st1.getStudent().add(s2);
		
		st2.getStudent().add(s2);
		
		
		
		
		cjc.getStaff().add(st1);
		cjc.getStaff().add(st2);
		
		cjc.getStudent().add(s1);
		cjc.getStudent().add(s2);
		
		session.save(cjc);
		session.beginTransaction().commit();
	}
}

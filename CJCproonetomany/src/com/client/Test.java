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
		cjc.setCjc_id(1);
		cjc.setAddr("Karvenagar");
		
		Student s1 = new Student();
		s1.setSid(1);
		s1.setSname("Nitin");
		s1.setCjc(cjc);
		
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Rahul");
		s2.setCjc(cjc);
		
		
		Staff st1 = new Staff();
		st1.setStaff_id(11);
		st1.setStaff_name("Kunal");
		st1.setCjc(cjc);
		
		Staff st2 = new Staff();
		st2.setStaff_id(12);
		st2.setStaff_name("Akshay");
		st2.setCjc(cjc);
		
		cjc.getStaff().add(st1);
		cjc.getStaff().add(st2);
		cjc.getStudent().add(s1);
		cjc.getStudent().add(s2);
		
		session.save(cjc);
		session.beginTransaction().commit();
		
		cjc =session.load(CJC.class, cjc.getCjc_id());
			System.out.println(cjc.getCjc_id());
			
			for (Staff staff : cjc.getStaff()) {
				System.out.println(staff.getStaff_id());
				System.out.println(staff.getStaff_name());
			}
			for (Student student : cjc.getStudent()) {
				System.out.println(student.getSid());
				System.out.println(student.getSname());
			}
		
	}
}

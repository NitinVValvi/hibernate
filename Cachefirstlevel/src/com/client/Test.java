package com.client;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Student;

import config.HibernateUtil;

public class Test {
@SuppressWarnings({ "rawtypes", "unchecked"})
public static void main(String[] args) {
	//SessionFactory sf = HibernateUtil.getSessionFactory();
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	/*
	 * Random r = new Random(); for (int i = 1; i <=10; i++) { Student s= new
	 * Student(); s.setRollno(i); s.setName("Name " +i); s.setMarks(r.nextInt(100));
	 * session.save(s); }
	 */
	session.beginTransaction();
	Query q = session.createQuery("from Student where rollno = 7");
	//List<Student> students = q.list();
	Student student = (Student)q.uniqueResult();
	System.out.println(student);
	
	/*
	 * for (Student s : students) { System.out.println(s); }
	 */
	
	session.getTransaction().commit();
}
}

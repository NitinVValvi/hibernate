package com.serviceImpl;

import java.util.List;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {
	Student s = new Student();
	Scanner sc = new Scanner(System.in);
	@Override
	public void save() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("number of student data to enter");
		int n = sc.nextInt();
		for (int i = 0; i <=n; i++) {
			Student s1 = new Student();
			System.out.println("Enter student id: ");
			s1.setSid(sc.nextInt());
			System.out.println("Enter the student name:");
			s1.setSname(sc.next());
			System.out.println("Enter the student address: ");
			s1.setAddr(sc.next());
			session.save(s1);
			session.beginTransaction().commit();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql =  "update Student set sname = ? where sid = ?";
		Query<Student> q = session.createQuery(hql);
		q.setParameter(0, "Mangesh");
		q.setParameter(1, 103);
		q.executeUpdate();
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Student s where s.sid = ? ";
		Query<Student> q = session.createQuery(hql);
		//System.out.println("Enter id to delete: ");
		
		q.setParameter(0,103);
		q.executeUpdate();
		tx.commit();
		
		
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void select() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		// to fetch all the data 
		String hql = "from Student";
		Query<Student> q = session.createQuery(hql);
		List<Student> l = q.getResultList();
		for (Student student : l) {
			System.out.println(student.getSid());
			System.out.println(student.getSname());
			System.out.println(student.getAddr());
		}
		// foreach demo java 8 and stream we can use stream only once we cannot reuse it
		l.forEach(i -> System.out.println(i.toString()));
		
		
	}
	
}

package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		//select * from student
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();
		//tx.commit();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		
		Root<Student> sturoot = cq.from(Student.class);
		
		cq.select(sturoot);
		Query<Student> q = session.createQuery(cq);
		
		List<Student> list = q.getResultList();
		
		list.forEach(l-> System.out.println(l.toString()));
	}
}

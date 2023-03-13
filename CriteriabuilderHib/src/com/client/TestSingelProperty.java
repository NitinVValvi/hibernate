package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.jandex.Main;

import com.config.HibernateUtil;
import com.model.Student;

public class TestSingelProperty {
	public static void main(String[] args) {
		//select name from student
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		
		Root<Student> sturoot = cq.from(Student.class);
		
		cq.select(sturoot.get("sname"));
		
		Query q = session.createQuery(cq);
		
		List<String> list = q.getResultList();
		
		for (String string : list) {
			System.out.println("Student name : "+string);
		}
	}
}

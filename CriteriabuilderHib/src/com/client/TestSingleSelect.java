package com.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.Student;

public class TestSingleSelect {
	public static void main(String[] args) {
		//select * from student where sid = 101;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		
		Root<Student> sturoot = cq.from(Student.class);
		
		cq.where(cb.equal(sturoot.get("sid"),102));
		Query q = session.createQuery(cq);
		
		List<Student> list = q.getResultList();
		
		list.forEach(l->System.out.println(l.toString()));
	}
}

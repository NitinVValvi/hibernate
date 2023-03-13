package com.client;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Student;

public class TestDelete {
	public static void main(String[] args) {
		
		//delete from student where sid =?
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);
		Root<Student> sturoot  = cd.from(Student.class);
		
		cd.where(cb.equal(sturoot.get("sid"), 105));
		
		Query q = session.createQuery(cd);
		
		q.executeUpdate();
		tx.commit();
		System.out.println("Data deleted successfully!!");
		
	}
}

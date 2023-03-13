package com.client;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.config.HibernateUtil;
import com.model.BackupStudent;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		
		Transaction tx = session.beginTransaction();
		
		String hql = "insert into BackupStudent (sid,sname,addr) select sid,sname,addr from Student";
		
		Query<BackupStudent> q = session.createQuery(hql);
		
		q.executeUpdate();
		tx.commit();
	}
}

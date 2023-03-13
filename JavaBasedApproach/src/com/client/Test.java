package com.client;

import java.util.Scanner;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Student s = new Student();
		while(true)
		{
		System.out.println("Enter Choice:\n"+"1.ADD STUDENT\n"+"2.EXIT\n");
		int no = sc.nextInt();
		switch(no)
		{
		
		case 1:System.out.print("Enter Student ID:");
		s.setSid(sc.nextInt());
		System.out.print("Enter Student Name: ");
		s.setName(sc.next());
		
		session.save(s);
		
		session.beginTransaction().commit();
		
		break;
		case 2 : System.out.println("Exit");
		return;
		}
	}
}
}

package com.client;

import java.util.Scanner;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.PanCard;
import com.model.Student;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		PanCard p = new PanCard();
		System.out.print("Enter Pan Id:");
		int pid = sc.nextInt();
		p.setPan_id(pid);
		
		System.out.print("Enter the pan name: ");
		String name = sc.next();
		p.setPan_name(name);
		
		Student stud = new Student();
		
		System.out.print("Enter the Student ID: ");
		int id = sc.nextInt();
		stud.setSid(id);
		
		System.out.print("Enter the Student Name: ");
		String sname = sc.next();
		stud.setSname(sname);

	
		stud.setP(p);
		session.save(stud);
		//session.save(p);
		
		session.beginTransaction().commit();
		session.close();
	}
}

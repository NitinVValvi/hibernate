package com.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;

import com.config.HibernateUtil;
import com.model.Doctor;
import com.service.DoctorData;

public class DoctorDataImpl implements DoctorData
{
	Scanner sc = new Scanner(System.in);
	Session session = HibernateUtil.getSessionFactory().openSession();
	Doctor doc = new Doctor();
	@Override
	public void add() {
		
		System.out.println("Enter the no. of doctors to insert:\n");
		int input = sc.nextInt();
		for(int i = 0 ; i<input ;i++)
		{
		System.out.print("Add Doctor Details!!\n");
		System.out.print("Enter Doctor ID: ");
		int doc_id = sc.nextInt();
		doc.setDocid(doc_id);
		System.out.print("Enter Doctor Name: ");
		String doc_name = sc.next();
		doc.setDocname(doc_name);
		System.out.print("Enter Doctor Degree: ");
		String doc_degree = sc.next();
		doc.setDocdegree(doc_degree);
		System.out.print("Enter Doctor Speciality:");
		String doc_speciality = sc.next();
		doc.setSpeciality(doc_speciality);
		session.save(doc);
		session.beginTransaction().commit();
		}
		
		//session.close();
		
	}

	@Override
	public void update() {
		System.out.print("Update Doctor Details\n");
		System.out.print("Enter Doctor ID: ");
		int doc_id = sc.nextInt();
		doc.setDocid(doc_id);
		System.out.println("Select choice you want to update\n"+"1.Update Name\n"+"2.Update Degree\n"+"3.Update Speciality");
		int input = sc.nextInt();
		
		doc = session.load(Doctor.class, doc.getDocid());
		if(input == 1)
		{
		System.out.print("Enter Doctor Name: " );
		doc.setDocname(sc.next());
		}else if(input == 2)
		{
			System.out.println("Enter doctor degree");
			doc.setDocdegree(sc.next());
		}
		else if(input == 3)
		{
			System.out.println("Enter speciality");
			doc.setSpeciality(sc.next());
		}
		session.update(doc);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void delete() {
		System.out.print("Delete Data!!\n");
		System.out.print("Enter doc id to delete the data:");
		doc.setDocid(sc.nextInt());
		
		session.update(doc);
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void retrieve() {
		System.out.print("Retrieve Data!!\n");
		
		System.out.print("Enter DocID to retrieve data: ");
		doc.setDocid(sc.nextInt());;
		doc = session.get(Doctor.class,doc.getDocid() );
		session.update(doc);
		System.out.println(doc.toString());
		/*
		 * System.out.print("Doctor ID: "+doc.getDocid()+"\n");
		 * System.out.print("Doctor Name: "+doc.getDocname()+"\n");
		 * System.out.print("Doctor Degree: "+doc.getDocdegree()+"\n");
		 * System.out.print("Doctor Speciality: "+doc.getSpeciality()+"\n");
		 */
		session.beginTransaction().commit();
		session.close();
	}

}

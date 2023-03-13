package com.client;

import java.util.Scanner;

import com.service.DoctorData;
import com.serviceImpl.DoctorDataImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DoctorData d = new DoctorDataImpl();
		while(true)
		{
			System.out.print("Enter the choice: \n"+"1.Add Student\n"+"2.Update Student\n"+"3.Delete Student\n"
					+"4.Retrive Student\n");
			int no = sc.nextInt();
			switch(no)
			{
			case 1 : d.add();
			break;
			
			case 2 : d.update();
			break;
			
			case 3 : d.delete();
			break;
			
			case 4 : d.retrieve();
			break;
			
			case 5 : System.out.println("Exit<--->adios!!!");
			return;
			}
		}
	}
}

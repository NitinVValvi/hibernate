package com.client;

import java.util.Scanner;

import com.service.EmployeeData;
import com.serviceImpl.EmployeeImp;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeData emp = new EmployeeImp();
		while(true)
		{
			System.out.println("Enter choice\n"+"1.Insert\n"+"2.Update\n"+"3.Delete\n"+"4.Select\n");
			int no = sc.nextInt();
			switch(no)
			{
			case 1: emp.insert();
			break;
			
			case 2: emp.update();
			break;
			
			case 3: emp.delete();
			break;
			
			case 4: emp.select();
			break;
			
			case 5: System.out.println("Exit");
			return;
			}
			
		}
	}
}

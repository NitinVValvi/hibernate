package com.client;

import java.util.Scanner;

import com.service.StudentService;
import com.serviceImpl.StudentServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService sts = new StudentServiceImpl();
		while(true)
		{
			System.out.print("Enter Choice:\n"+"\n1.to save "+"\n2.to update"+"\n3.to delete"+"\n4.to select");
			int no = sc.nextInt();
			if(no!=5)
			switch(no)
				{
					case 1 : sts.save();
					break;
					case 2 : sts.update();
					break;
					case 3 : sts.delete();
					break;
					case 4 :sts.select();
					break;
				}
				else
				{
					System.out.println("Exit");
					sc.close();
					return;
				}
		}
	}
}

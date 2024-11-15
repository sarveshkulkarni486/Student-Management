package com.example.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.example.services.StudentServices;
import com.example.services.StudentServicesImpl;

public class TestStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentServices sserv = new StudentServicesImpl();
		int choice = 0;
		do {
			System.out.println("Enter your choice: ");
			System.out.println("1. Add student  \n2. Delete student \n3. Update student name ");
			System.out.println("4.Update student marks  \n5. Display all student \n6. Find total no of students");
			System.out.println("7.Sort by Name  \n8. Exit");
			choice = sc.nextInt();
			switch (choice) {
				case 1-> {
					sserv.AddStudent();
				}	
				case 2-> {
					sserv.DeleteStudent();
				}
				case 3-> {
					sserv.UpdateStudentName();
				}
				case 4-> {
					sserv.UpdateStudentMarks();
				}
				case 5-> {
					sserv.DisplayData();
				}
				case 6-> {
					sserv.CountTotal();
				}
				case 7-> {
					sserv.SortByName();
				}
				case 8-> {
					System.out.println("Thank you...");
				}
				default -> {
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
		}

	}while(choice!=8);
	}
}

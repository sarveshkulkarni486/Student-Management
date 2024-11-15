package com.example.services;

import java.util.Scanner;

import com.example.beans.Student;
import com.example.dao.StudentDao;
import com.example.dao.StudentDaoImpl;

public class StudentServicesImpl implements StudentServices {
	Scanner sc = new Scanner(System.in);
	StudentDao sdao = new StudentDaoImpl();
	@Override
	public void AddStudent() {
		System.out.println("Enter student id: ");
		int id = sc.nextInt();
		System.out.println("Enter student name: ");
		String sname = sc.next();
		System.out.println("Enter student marks: ");
		double marks = sc.nextDouble();
		Student s = new Student(id, sname, marks);
		sdao.InsertData(s);
	}

	@Override
	public void DeleteStudent() {
		System.out.println("Enter id of student which you want to delete");
		int id = sc.nextInt();
		sdao.DeleteData(id);
		
	}

	@Override
	public void UpdateStudentName() {
		System.out.println("enter student id of who's you want to update name: ");
		int id = sc.nextInt();
		System.out.println("Enter student new name ");
		String sname =sc.next();
		sdao.UpdateData(id, sname);
		
	}

	@Override
	public void UpdateStudentMarks() {
		System.out.println("Enter student id of who's you want to update marks: ");
		int id = sc.nextInt();
		System.out.println("Enter student new marks: ");
		double marks = sc.nextDouble();
		sdao.updateMarks(id, marks);
	}

	@Override
	public void DisplayData() {
		sdao.SelectData();
	}

	@Override
	public void CountTotal() {
		sdao.Count();
	}

	@Override
	public void SortByName() {
		sdao.sortByName();
	}

}

package com.example.dao;

import com.example.beans.Student;

public interface StudentDao {

	void InsertData(Student s);

	void DeleteData(int id);

	void UpdateData(int id, String sname);

	void updateMarks(int id, double marks);

	void SelectData();

	void Count();

	void sortByName();

}

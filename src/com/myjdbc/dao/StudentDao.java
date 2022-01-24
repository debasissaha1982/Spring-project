package com.myjdbc.dao;

import java.util.List;

import com.myjdbc.api.Student;

public interface StudentDao {
	
	void insert(Student student);
	
	boolean deletebyStudentid(int studentID);
	
	List<Student>findAllStudents();
	
	Student findStudentbyid(int studentId);


}

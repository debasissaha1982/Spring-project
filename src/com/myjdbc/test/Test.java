package com.myjdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myjdbc.api.Student;
import com.myjdbc.dao.StudentDao;
import com.myjdbc.dao.StudentDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Application context file loaded");
		
		StudentDaoImpl studentDaoImpl = context.getBean("studentDao",StudentDaoImpl.class);
		
		Student newStudent1 = new Student();
		newStudent1.setRollno(05);
		newStudent1.setName("Sukhendra Nath Saha");
		newStudent1.setAddress("Domkal");
		
		//studentDaoImpl.insert(newStudent1);
		//studentDaoImpl.deletebyStudentid(5);
		
		List<Student> studentlist = studentDaoImpl.findAllStudents();
		
		for (Student tempstudent : studentlist) {
			System.out.println(tempstudent.getName());
			
		}
		
		Student studentbyid = studentDaoImpl.findStudentbyid(3);
		System.out.println(studentbyid);
		
		//Configured in Spring Bean XML
		//StudentDao studentdao = new StudentDaoImpl();
		//studentdao.insert(newStudent1);

	}

}

package com.myjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.myjdbc.api.Student;
import com.myjdbc.rowmapper.StudentRowMapper;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	//Configured in Spring Bean XML
	//private JdbcTemplate jdbctemplete = new JdbcTemplate(getDataSource()); // Creating JdbcTemplate Object
	
	@Autowired
	private JdbcTemplate jdbctemplete;

	public void setJdbctemplete(JdbcTemplate jdbctemplete) {
		this.jdbctemplete = jdbctemplete;
	}


	@Override
	public void insert(Student student) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
		
		Object[] obj = {student.getRollno(),student.getName(),student.getAddress()};
		
		int numberOfRow= jdbctemplete.update(sql,obj);
		
		System.out.println("Number of Inserted"+numberOfRow);
		
	}


	@Override
	public boolean deletebyStudentid(int studentID) {
		// TODO Auto-generated method stub
		
		String sql = "DELETE FROM STUDENT WHERE idStudent = ?";
		int numberOfRowDeleted = jdbctemplete.update(sql,studentID);
		System.out.println("One Row Delete from the Table");
		
		return numberOfRowDeleted==1;
	}

	//Fetch all the record using Custom RowMapper
	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		
		String selectQuery = "SELECT * FROM STUDENT";
		List<Student> studentList= jdbctemplete.query(selectQuery, new StudentRowMapper());
		
		return studentList;
	}

	
	//Fetch all the record using BeanPropertyRowMapper by Spring Framework
	@Override
	public Student findStudentbyid(int studentId) {
		// TODO Auto-generated method stub
		//******To facilitate mapping between columns and fields that don't have matching names, 
		//******try using column aliases in the SQL statement like "select fname as first_name from customer
		
		String selectQuery = "SELECT idStudent as rollno, Studebt_Name as name, Student_Address as address FROM STUDENT WHERE idStudent=?";
		Student studentbyid = jdbctemplete.queryForObject(selectQuery, new BeanPropertyRowMapper<Student>(Student.class), studentId);
		return studentbyid;
	}
	
	//Configured in Spring Bean XML
	/*DataSource getDataSource() { 
		String url = "jdbc:mysql://localhost:3306/school";
		String username ="root";
		String pass = "Welcome@123";
		
		DataSource dataSource = new DriverManagerDataSource(url, username, pass); // Creating DriverManagerDataSource object
		
		return dataSource;
		
	}*/
	

}

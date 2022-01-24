package com.myjdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myjdbc.api.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet res, int rowNumber) throws SQLException {
		// TODO Auto-generated method stub
		
		Student newStudent = new Student();
		
		newStudent.setRollno(res.getInt("idStudent"));
		newStudent.setName(res.getString("Studebt_Name"));
		newStudent.setAddress(res.getString("Student_Address"));
		
		return newStudent;
	}

}

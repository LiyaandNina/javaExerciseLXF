package com.itranswarp.learnjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * App entry for Maven project.
 * 
 * @author liaoxuefeng
 */
public class Main {

	static final String jdbcUrl = "jdbc:mysql://localhost/learnjdbc?useSSL=false&characterEncoding=utf8&allowPublicKeyRetrieval=true";
	static final String jdbcUsername = "learn";
	static final String jdbcPassword = "learnpassword";

	public static void main(String[] args) throws Exception {
		List<Student> students = queryStudents();
		students.forEach(System.out::println);
	}

	static List<Student> queryStudents() throws SQLException {
		List<Student> students = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)){
			try(PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")){
				ps.setInt(1, 2);
				ps.setInt(2, 90);
				try(ResultSet rs = ps.executeQuery()){
					while (rs.next()){
						students.add(extractRow(rs));
					}
				}
			}
		}
		return students;
	}

	static Student extractRow(ResultSet rs) throws SQLException {
		var student = new Student();
		student.setId(rs.getLong("id"));
		student.setName(rs.getString("name"));
		student.setGender(rs.getBoolean("gender"));
		student.setGrade(rs.getInt("grade"));
		student.setScore(rs.getInt("score"));
		return student;
	}

}

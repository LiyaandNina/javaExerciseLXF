package com.itranswarp.learnjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) throws SQLException {
        insertStudent("大黄", true, 3, 100);
        insertStudent("大头", false, 3, 101);
        deleteStudent();
        queryStudents();
    }

    static void insertStudent(String name, boolean gender, int grade, int score) throws SQLException{
        try (Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)) {
            Boolean isAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)"
            )) {
                ps.setString(1, name);
                ps.setBoolean(2, gender);
                ps.setInt(3, grade);
                ps.setInt(4, score);
                int n = ps.executeUpdate();
                System.out.println(n + " inserted.");
            }
            if (score > 100) {
                conn.rollback();
                System.out.println("rollback.");
            } else {
                conn.commit();
                System.out.println("commit.");
            }
            conn.setAutoCommit(isAutoCommit);
        }
    }

    static void deleteStudent() throws SQLException {
        try (Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id > 19")){
                int n = ps.executeUpdate();
                System.out.println(n + " deleted.");
            }
        }
    }

    static void queryStudents() throws SQLException{
        List<Student> students = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)){
            try(PreparedStatement ps = conn.prepareStatement("SELECT * FROM students")){
                try(ResultSet rs = ps.executeQuery()){
                    while (rs.next()){
                        students.add(extractRow(rs));
                    }
                }
            }
        }
        students.forEach(System.out::println);
    }

    static Student extractRow(ResultSet rs) throws SQLException {
        var std = new Student();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getBoolean("gender"));
        std.setGrade(rs.getInt("grade"));
        std.setScore(rs.getInt("score"));
        return std;
    }
}

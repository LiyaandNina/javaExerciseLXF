package com.itranswarp.learnjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Review {
    public static void main(String[] args) throws SQLException {
        updateSpecStudent();
        addNewStudent();
        queryAllStudents();
        deleteStudents();
        queryAllStudents();
    }

    static void addNewStudent() throws SQLException{
        try(Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)){
            try(PreparedStatement preps = conn.prepareStatement(
                    "INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            )){
                preps.setString(1, "老王2");
                preps.setBoolean(2, true);
                preps.setInt(3, 3);
                preps.setInt(4, 99);
                int n = preps.executeUpdate();
                System.out.println(n + " inserted.");
                long id = 0;
                try(ResultSet rs = preps.getGeneratedKeys()){
                    if (rs.next()){
                        id = rs.getLong(1);
                        System.out.println("id= " + id + ".");
                    }
                }
            }
        }
    }

    static void deleteStudents() throws SQLException{
        try(Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)){
            try(PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id > ?")){
                ps.setInt(1, 14);
                int n = ps.executeUpdate();
                System.out.println(n + " deleted.");
            }
        }
    }

    static void updateSpecStudent() throws SQLException{
        try(Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)){
            try(PreparedStatement preps = conn.prepareStatement("UPDATE students SET score = ? WHERE name = ?")){
                preps.setInt(1, 99);
                preps.setString(2, "小贝");
                int n = preps.executeUpdate();
                System.out.println(n + " updated.");
            }
        }
    }

    static void queryAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Main.jdbcUrl, Main.jdbcUsername, Main.jdbcPassword)){
            try(PreparedStatement preps = conn.prepareStatement("SELECT * FROM students")){
                try(ResultSet rs = preps.executeQuery()){
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

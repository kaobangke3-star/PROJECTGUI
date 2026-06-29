/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author lenov
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import util.DBConnection;

public class CourseDAO {
    private Connection connection;

    public CourseDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertCourse(Course course) {
        String sql = "INSERT INTO courses (code, name, sks, semester) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getSKS());
            stmt.setString(4, course.getSemester());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Course> getCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Pemisahan pengambilan variabel ResultSet sebelum dimasukkan ke objek
                int id = rs.getInt("courseID");
                String code = rs.getString("code");
                String name = rs.getString("name");
                int sks = rs.getInt("sks");
                String sem = rs.getString("semester");

                Course c = new Course(code, name, id, sks);
                list.add(c);
            }
        } catch (SQLException e) {
            Logger.getLogger(CourseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updateCourse(Course course) {
        String sql = "UPDATE courses SET code=?, name=?, sks=?, semester=? WHERE courseID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, course.getCode());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getSKS());
            stmt.setString(4, course.getSemester());
            stmt.setInt(5, course.getCourseID());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteCourse(int courseID) {
        String sql = "DELETE FROM courses WHERE courseID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, courseID);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}
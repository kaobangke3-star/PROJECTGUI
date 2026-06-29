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
import model.Student;
import util.DBConnection;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
    try {
        connection = DBConnection.getConnection();
        if (connection == null) {
            System.out.println("[PERINGATAN] Gagal terhubung ke database! Periksa DBConnection Anda.");
        }
    } catch (SQLException ex) {
        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    // 1. Create Student (Menggunakan studiprogram huruf kecil)
    public int insertStudent(Student student) {
        try {
            String sql = "INSERT INTO student (NIK, NIM, name, studiProgram) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getNik());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getstudiProgram());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // 2. Read All Students
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student s = new Student(
                                        rs.getString("NIK"),
                    rs.getString("NIM"),
                    rs.getString("name"),
                    rs.getString("studiProgram") // disamakan huruf kecil
,               rs.getInt("studentID")                );
                list.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    // 3. Update Student
    public int updateStudent(Student student) {
        try {
            String sql = "UPDATE student SET NIK=?, NIM=?, name=?, studProgram=? WHERE studentID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getNik());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getstudiProgram());
            stmt.setInt(5, student.getStudentID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }
    
    // 4. Delete Student
    public int deleteStudent(int studentID) {
        try {
            String sql = "DELETE FROM student WHERE studentID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, studentID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}
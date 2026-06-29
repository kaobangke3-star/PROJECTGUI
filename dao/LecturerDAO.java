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
import model.Lecturer;
import util.DBConnection;

public class LecturerDAO {
    private Connection connection;

    public LecturerDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertLecturer(Lecturer lecturer) {
        String sql = "INSERT INTO lectures (name, cardID, nidn, expertise) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getNik());
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getBidangKeahlian());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Lecturer> getLecturers() {
        List<Lecturer> list = new ArrayList<>();
        String sql = "SELECT * FROM lectures";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("lecturesID");
                String cardId = rs.getString("cardID");
                String nidn = rs.getString("nidn");
                String name = rs.getString("name");
                String exp = rs.getString("expertise");

                Lecturer l = new Lecturer(id, cardId, nidn, name);
                l.setBidangKeahlian(exp);
                list.add(l);
            }
        } catch (SQLException e) {
            Logger.getLogger(LecturerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updateLecturer(Lecturer lecturer) {
        String sql = "UPDATE lectures SET name=?, cardID=?, nidn=?, expertise=? WHERE lectureID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecturer.getName());
            stmt.setString(2, lecturer.getNik());
            stmt.setString(3, lecturer.getNidn());
            stmt.setString(4, lecturer.getBidangKeahlian());
            stmt.setInt(5, lecturer.getLecturerID());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteLecturer(int lecturesID) {
        String sql = "DELETE FROM lectures WHERE lectureID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, lecturesID);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}
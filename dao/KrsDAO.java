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
import model.KRS;
import util.DBConnection;

public class KrsDAO {
    private Connection connection;

    public KrsDAO() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(KrsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertKRS(KRS krs) {
        String sql = "INSERT INTO krs (code, nim, nidn, semester, score, grade) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, krs.getCode());
            stmt.setString(2, krs.getNim());
            stmt.setString(3, krs.getNidn());
            stmt.setString(4, krs.getSemester());
            stmt.setDouble(5, krs.getScore());
            stmt.setString(6, krs.getGrade());
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert KRS: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<KRS> getKRSList() {
        List<KRS> list = new ArrayList<>();
        String sql = "SELECT * FROM krs";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("krsID");
                String code = rs.getString("code");
                String nim = rs.getString("nim");
                String nidn = rs.getString("nidn");
                String semester = rs.getString("semester");
                double score = rs.getDouble("score");

                KRS k = new KRS(id, code, nim, nidn, semester, score);
                list.add(k);
            }
        } catch (SQLException e) {
            Logger.getLogger(KrsDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Delete
    public int deleteKRS(int krsID) {
        String sql = "DELETE FROM krs WHERE krsID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, krsID);
            
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete KRS: " + e.getMessage());
            return 0;
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lenov
 */
import dao.LecturerDAO;
import java.util.List;
import model.Lecturer;

public class LecturerController {
    private final LecturerDAO lecturerDao;

    public LecturerController() {
        this.lecturerDao = new LecturerDAO();
    }

    public int addLecturer(Lecturer lecturer) {
        int result = lecturerDao.insertLecturer(lecturer);
        return result;
    }

    public List<Lecturer> getLecturers() {
        List<Lecturer> lecturersList = lecturerDao.getLecturers();
        return lecturersList;
    }

    public int updateLecturer(Lecturer lecturer) {
        int result = lecturerDao.updateLecturer(lecturer);
        return result;
    }

    public int deleteLecturer(int lectureID) {
        int result = lecturerDao.deleteLecturer(lectureID);
        return result;
    }
}
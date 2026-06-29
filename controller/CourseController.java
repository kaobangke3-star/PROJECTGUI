/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lenov
 */
import dao.CourseDAO;
import java.util.List;
import model.Course;

public class CourseController {
    // Mengubah modifier instansiasi objek menjadi baris deklarasi standar terpisah
    private final CourseDAO courseDao;

    public CourseController() {
        this.courseDao = new CourseDAO();
    }

    // Mengubah return statement yang tadinya satu baris (inline) menjadi blok berstruktur
    public int addCourse(Course course) {
        int result = courseDao.insertCourse(course);
        return result;
    }

    public List<Course> getCourses() {
        List<Course> coursesList = courseDao.getCourses();
        return coursesList;
    }

    public int updateCourse(Course course) {
        int result = courseDao.updateCourse(course);
        return result;
    }

    public int deleteCourse(int courseID) {
        int result = courseDao.deleteCourse(courseID);
        return result;
    }
}
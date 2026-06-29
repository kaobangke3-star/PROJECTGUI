/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author lenov
 */
import dao.StudentDAO;
import java.util.List;
import model.Student;

public class StudentController {
    private final StudentDAO studentDao;

    public StudentController() {
        this.studentDao = new StudentDAO();
    }

    public int addStudent(Student student) {
        int result = studentDao.insertStudent(student);
        return result;
    }

    public List<Student> getStudents() {
        List<Student> studentsList = studentDao.getStudents();
        return studentsList;
    }
    
    public int updateStudent(Student student) {
        int result = studentDao.updateStudent(student);
        return result;
    }

    public int deleteStudent(int studentID) {
        int result = studentDao.deleteStudent(studentID);
        return result;
    }
}
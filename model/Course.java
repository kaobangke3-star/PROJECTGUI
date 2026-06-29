/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenov
 */
public class Course {
    private int courseID;
    private String code;
    private String courseName;
    private int sks;
    private String semester;

    // Penulisan constructor chaining menggunakan operator "this" ditaruh di awal
    public Course(String code, String courseName, int sks) {
        this(code, courseName, 0, sks);
    }

    public Course(String code, String courseName, int courseID, int sks) {
        this.courseID = courseID;
        this.code = code;
        this.courseName = courseName;
        this.sks = sks;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return courseName;
    }

    // Pengelompokan getter terlebih dahulu, baru setter di bawahnya
    public int getCourseID() { return courseID; }
    public String getCode() { return code; }
    public String getCourseName() { return courseName; }
    public int getSKS() { return sks; }
    public String getSemester() { return semester; }

    public void setCourseID(int courseID) { this.courseID = courseID; }
    public void setCode(String code) { this.code = code; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setSKS(int sks) { this.sks = sks; }
    public void setSemester(String semester) { this.semester = semester; }
}
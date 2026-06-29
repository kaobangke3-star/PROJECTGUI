/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenov
 */
public class KRS {
    private int krsID;
    private String code;
    private String nim;
    private String nidn;
    private String semester;
    private final double score;
    private final String grade;
    private final Course course;

    public KRS(int krsID, String code, String nim, String nidn, String semester, double score) {
        this.krsID = krsID;
        this.code = code;
        this.nim = nim;
        this.nidn = nidn;
        this.semester = semester;
        this.score = score;
        this.grade = setGrade();
        this.course = null;
    }

    public KRS(Course course, double score) {
        this.course = course;
        this.score = score;
        this.grade = setGrade();
        // Mengubah penulisan ternary operator menjadi if-else biasa
        if (course != null) {
            this.code = course.getCode();
        } else {
            this.code = "";
        }
    }

    // Mengubah logika penulisan if-else (menggunakan "return langsung" tanpa "else if")
    private String setGrade() {
        if (score >= 85) return "A";
        if (score >= 75) return "B";
        if (score >= 60) return "C";
        return "D";
    }

    public int getKrsID() { return krsID; }
    public String getCode() { return code; }
    public String getNim() { return nim; }
    public String getNidn() { return nidn; }
    public String getSemester() { return semester; }
    public double getScore() { return score; }
    public String getGrade() { return grade; }
    public Course getCourse() { return course; }

    public void setCode(String code) { this.code = code; }
    public void setNim(String nim) { this.nim = nim; }
    public void setNidn(String nidn) { this.nidn = nidn; }
    public void setSemester(String semester) { this.semester = semester; }
}
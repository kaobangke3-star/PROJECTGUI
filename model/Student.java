/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenov
 */
import java.util.ArrayList;

import java.util.List;



public class Student {

    private int studentID;

    private String nik;

    private String nim;

    private String name;

    private String studiProgram;

    private final List<KRS> krsList;
    private int jumlahSKS;



    public Student(String nik, String nim, String name, String studiProgram, int studentID) {

        this.studentID = studentID;

        this.nik = nik;

        this.nim = nim;

        this.name = name;

        this.studiProgram = studiProgram;

        this.krsList = new ArrayList<>();

    }



    public Student(String nik, String name, String nim, String studiProgram) {

        this(nik, nim, name, studiProgram, 0);

    }



    public void addKRS(KRS krs) {

        this.krsList.add(krs);

    }



    public List<KRS> getKrsList() {

        return this.krsList;

    }



    @Override

    public String toString() {

        return name;

    }



    // --- GETTER & SETTER ---

    public int getStudentID() { return studentID; }

    public String getNik() { return nik; }

    public String getCardID() { return nik; }

    public String getNim() { return nim; }

    public String getName() { return name; }

    

    // Method ini dibuat dengan dua variasi huruf (besar & kecil) 

    // agar mencakup panggilan dari StudentDAO (getstudiProgram) maupun StudentForm (getStudiProgram)

    public String getStudiProgram() { return studiProgram; }

    public String getstudiProgram() { return studiProgram; } 

    public String getStudyProgram() { return studiProgram; }



    public void setStudentID(int studentID) { this.studentID = studentID; }

    public void setNik(String nik) { this.nik = nik; }

    public void setCardID(String nik) { this.nik = nik; }

    public void setNim(String nim) { this.nim = nim; }

    public void setName(String name) { this.name = name; }

    public void setStudiProgram(String studiProgram) { this.studiProgram = studiProgram; }

    public String getNIM() {
        return this.nim;
    }

    public int getJumlahSKS() {
        return this.jumlahSKS;
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenov
 */
public class Lecturer extends Person {
    private int lecturerID;
    private String nidn;
    private String bidangKeahlian;

    // Membalik urutan constructor (manual di atas, DB di bawah)
    public Lecturer(String nik, String nidn, String name) {
        super(nik, name);
        this.lecturerID = 0;
    }

    public Lecturer(int lecturerID, String nik, String nidn, String name) {
        super(nik, name);
        this.lecturerID = lecturerID;
        this.nidn = nidn;
    }

    public Lecturer(String nik, String name, String nidn, String bidangKeahlian) {
        super(nik, name);
        this.nidn = nidn;
        this.bidangKeahlian = bidangKeahlian;
    }

    @Override
    public String toString() {
        return name;
    }

    // Mengubah susunan baris getter & setter
    public int getLecturerID() { return this.lecturerID; }
    public String getNidn() { return this.nidn; }
    public String getBidangKeahlian() { return this.bidangKeahlian; }

    public void setLecturerID(int lecturerID) { this.lecturerID = lecturerID; }
    public void setNidn(String nidn) { this.nidn = nidn; }
    public void setBidangKeahlian(String bidangKeahlian) { this.bidangKeahlian = bidangKeahlian; }
}
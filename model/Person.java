/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenov
 */
public class Person {
    protected String nik;
    protected String name;

    public Person(String nik, String name) {
        this.nik = nik;
        this.name = name;
    }

    // Mengubah inline getter/setter menjadi blok standar bergaya konvensional
    public String getNik() { 
        return this.nik; 
    }
    
    public void setNik(String nik) { 
        this.nik = nik; 
    }

    public String getName() { 
        return this.name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
}
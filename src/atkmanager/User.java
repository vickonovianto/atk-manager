/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

/**
 *
 * @author adinb
 */
public class User {
    private int ID;
    private String name;
    private String type;
    
    public User (int ID, String name, String type){
        this.name = name;
        this.type = type;
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public static boolean isKategoriValid(String kategori){
        return !(kategori.equals("Mahasiswa") || kategori.equals("Dosen") || kategori.equals("Staf"));
    }
}

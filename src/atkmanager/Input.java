/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

//import java.sql.Connection;

import java.text.SimpleDateFormat;

//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author adinb
 */
public class Input {
    DBHelper db = DBHelper.getInstance();
    
    public void AddATK(String nama_atk, int jumlah_atk, int id_penyedia){
        String sql =    "INSERT INTO ATK (nama_atk, jumlah_atk, id_penyedia) VALUES ('" + nama_atk + "', " + jumlah_atk + ", " + id_penyedia + ");";
        db.runUpdate(sql);
    }
    
    public void AddUser(String nama_pemesan, String kategori){
        String sql = "INSERT INTO pemesan (nama_pemesan, kategori) VALUES ('" + nama_pemesan + "', '" + kategori + "');";
        db.runUpdate(sql);
    }
    
    public void AddSupplier(String nama_penyedia){
        String sql = "INSERT INTO penyedia (nama_penyedia) VALUES ('" + nama_penyedia + "');";
        db.runUpdate(sql);
    }
    
    public void AddTransaction(Transaction transaction){
        String date = new SimpleDateFormat("dd/MM/yyyy").format(transaction.getTransactionDate());
        String sql = "INSERT INTO pesananATK (id_pemesan, id_atk, jumlah, tanggal_pesanan) VALUES (" + transaction.getUser().getID() + ", " + transaction.getItem().getID() + ", " + transaction.getNumbers() + ", " + date + ");";
        db.runUpdate(sql);
    }
    
    public void AddOrder(Order order){
        String sql = "INSERT INTO pengadaan (id_penyedia, id_atk, jumlah, tanggal_pengadaan) VALUES (" + order.getSupplier().getID() + ", " + order.getItem().getID() + ", " + order.getNumbers() + ", " + order.getReceivedDate() + ");";
        db.runUpdate(sql);
    }
    
    public void DeleteUser(int id){
        String sql = "DELETE FROM pemesan WHERE id_pemesan = " + id +";";
        db.runUpdate(sql);
    }

    void DeleteATK(int id) {
        String sql = "DELETE FROM atk WHERE id_atk = " + id +";";
        db.runUpdate(sql);
    }
    
    void DeleteSupplier(int id) {
        String sql = "DELETE FROM penyedia WHERE id_penyedia = " + id +";";
        db.runUpdate(sql);
    }
}

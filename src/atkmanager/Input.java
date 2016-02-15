/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author adinb
 */
public class Input {
    DBHelper db = new DBHelper();
    
    public void AddATK(ATK atk){
        String sql =    "INSERT INTO ATK (nama_atk, jumlah_atk, id_penyedia) VALUES ('" + atk.getName() + "', " + atk.getNumber() + ", " + atk.getSupplierID() + ");";
        db.runUpdate(sql);
    }
    
    public void AddUser(User user){
        String sql = "INSERT INTO pemesan (nama_pemesan, kategori) VALUES ('" + user.getName() + "', '" + user.getType() + "');";
        db.runUpdate(sql);
    }
    
    public void AddSupplier(Supplier supplier){
        String sql = "INSERT INTO penyedia (nama_penyedia) VALUES ('" + supplier.getName() + "');";
        db.runUpdate(sql);
    }
    
    public void AddTransaction(Transaction transaction){
        String sql = "INSERT INTO pesananATK (id_pemesan, id_atk, jumlah, tanggal_pesanan) VALUES (" + transaction.getUser().getID() + ", " + transaction.getItem().getID() + ", " + transaction.getNumbers() + ", " + transaction.getTransactionDate() + ");";
        db.runUpdate(sql);
    }
    
    public void AddOrder(Order order){
        String sql = "INSERT INTO pengadaan (id_penyedia, id_atk, jumlah, tanggal_pengadaan) VALUES (" + order.getSupplier().getID() + ", " + order.getItem().getID() + ", " + order.getNumbers() + ", " + order.getReceivedDate() + ");";
        db.runUpdate(sql);
    }
}

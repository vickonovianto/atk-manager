/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adinb
 */
public class Display {
    ArrayList<ATK> atkList;
    ArrayList<User> userList;
    ArrayList<Supplier> supplierList;
    ArrayList<Transaction> transactionList;
    ArrayList<Order> orderList;
    DBHelper dbhelper;
    
    public Display (){
        atkList = new ArrayList<>();
        userList = new ArrayList<>();
        supplierList = new ArrayList<>();
        transactionList = new ArrayList<>();
        orderList = new ArrayList<>();
        dbhelper = new DBHelper();
    }

    public void refreshList(){
        atkList = getAtkList();
        userList = getUserList();
        supplierList = getSupplierList();
        transactionList = getTransactionList();
//        orderList = getOrderList();
    }
    public ArrayList<ATK> getAtkList() {
        atkList = new ArrayList<>();
        try {
            int i = 1;
            ResultSet result = dbhelper.runQuery("select * from atk");
            ATK atk;
            while (result.next()){
               atk = new ATK(result.getInt("id_atk"), result.getString("nama_atk"), result.getInt("jumlah_atk"), result.getInt("id_penyedia"));
               atkList.add(atk);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return atkList;
    }

    public ArrayList<User> getUserList() {
        userList = new ArrayList<>();
        try {
            int i = 1;
            User user;
            ResultSet result = dbhelper.runQuery("select * from pemesan");
            
            while (result.next()){
                user = new User(result.getInt("id_pemesan"), result.getString("nama_pemesan"), result.getString("kategori"));
                userList.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userList;
    }

    public ArrayList<Supplier> getSupplierList() {
        supplierList = new ArrayList<>();
        try {
            int i = 1;
            Supplier supplier;
            ResultSet result = dbhelper.runQuery("select * from penyedia");
            
            while (result.next()){
                supplier = new Supplier(result.getInt("id_penyedia"), result.getString("nama_penyedia"));
                supplierList.add(supplier);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return supplierList;
    }

    public ArrayList<Transaction> getTransactionList() {
        transactionList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            int i = 1;
            Transaction transaction;
            ResultSet result = dbhelper.runQuery("select pemesan.id_pemesan, pemesan.nama_pemesan, pemesan.kategori, atk.id_atk, atk.nama_atk, pesananATK.jumlah, tanggal_pesanan, status from pesananATK INNER JOIN atk ON pesananATK.id_atk = atk.id_atk INNER JOIN pemesan ON pesananATK.id_pemesan = pemesan.id_pemesan");
            
            while (result.next()){
                transaction = new Transaction(new User(result.getInt("id_pemesan"), result.getString("nama_pemesan"), result.getString("kategori")), 
                        new ATK(result.getInt("id_atk"), result.getString("nama_atk"),0,0), result.getInt("jumlah"), format.parse(result.getString("tanggal_pesanan")), result.getInt("status"));
                transactionList.add(transaction);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactionList;
    }

    public ArrayList<Order> getOrderList() {
        orderList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            int i = 1;
            Order order;
            ResultSet result = dbhelper.runQuery("select tanggal_pengadaan, penyedia.id_penyedia, penyedia.nama_penyedia, atk.id_atk, atk.nama_atk, pengadaan.jumlah from pengadaan inner join atk on pengadaan.id_atk = atk.id_atk inner join penyedia on penyedia.id_penyedia = pengadaan.id_penyedia");
            
            while (result.next()){
                order = new Order(new Supplier(result.getInt("id_penyedia"), result.getString("nama_penyedia")), 
                        new ATK(result.getInt("id_atk"), result.getString("nama_atk"), 0, 0), result.getInt("jumlah"), format.parse(result.getString("tanggal_pengadaan")));
                orderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("order size: "+ orderList.size());
        return orderList;
    }
    
    public int getSupplierIDByName(String name){
        int id = 1; 
        
        try {
            ResultSet result = dbhelper.runQuery("select * from penyedia WHERE nama_penyedia = '" + name + "';");
            
            while (result.next()){
                id = result.getInt("id_penyedia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public String getSupplierNameByID(int id){
        
        String name = null;
        
        try {
            ResultSet result = dbhelper.runQuery("select * from penyedia WHERE id_penyedia = " + id + ";");
            
            while (result.next()){
                name = result.getString("nama_penyedia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
    public String getUserNameByID(int id){
        
        String name = null;
        
        try {
            ResultSet result = dbhelper.runQuery("select * from pemesan WHERE id_pemesan = " + id + ";");
            
            while (result.next()){
                name = result.getString("nama_pemesan");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
    public String getATKNameByID(int id){
        
        String name = null;
        
        try {
            ResultSet result = dbhelper.runQuery("select * from atk WHERE id_atk = " + id + ";");
            
            while (result.next()){
                name = result.getString("nama_atk");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
}

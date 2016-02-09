/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ArrayList<ATK> getAtkList() {
        try {
            int i = 1;
            ResultSet result = dbhelper.runQuery("select * from atk");
            ATK atk;
            while (result.next()){
               atk = new ATK(result.getString("nama"), result.getInt("jumlah"));
               atkList.add(atk);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return atkList;
    }

    public ArrayList<User> getUserList() {
        try {
            int i = 1;
            User user;
            ResultSet result = dbhelper.runQuery("select * from pemesan");
            
            while (result.next()){
                user = new User(result.getString("nama"), result.getString("kategori"));
                userList.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userList;
    }

    public ArrayList<Supplier> getSupplierList() {
        try {
            int i = 1;
            Supplier supplier;
            ResultSet result = dbhelper.runQuery("select * from penyedia");
            
            while (result.next()){
                supplier = new Supplier(result.getString("nama"));
                supplierList.add(supplier);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return supplierList;
    }

    public ArrayList<Transaction> getTransactionList() {
        try {
            int i = 1;
            Transaction transaction;
            ResultSet result = dbhelper.runQuery("select * from pesananATK join atk join pemesan");
            
            while (result.next()){
                transaction = new Transaction(new User(result.getString("pemesan.name"), result.getString("pemesan.kategori")), new ATK(result.getString("atk.name"),0), result.getInt("pesananATK.jumlah"), new Date());
                transactionList.add(transaction);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transactionList;
    }

    public ArrayList<Order> getOrderList() {
        try {
            int i = 1;
            Order order;
            ResultSet result = dbhelper.runQuery("select * from pengadaan join atk join penyedia");
            
            while (result.next()){
                order = new Order(new Supplier(result.getString("penyedia.nama")), new ATK(result.getString("atk.nama"), 0), result.getInt("pengadaan.jumlah"), new Date());
                orderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderList;
    }
    
}

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

    public void refreshList(){
        atkList = getAtkList();
        userList = getUserList();
        supplierList = getSupplierList();
        transactionList = getTransactionList();
        orderList = getOrderList();
    }
    public ArrayList<ATK> getAtkList() {
        atkList = new ArrayList<>();
        try {
            int i = 1;
            ResultSet result = dbhelper.runQuery("select * from atk");
            ATK atk;
            while (result.next()){
               atk = new ATK(result.getString("nama_atk"), result.getInt("jumlah_atk"), result.getInt("id_penyedia"));
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
                user = new User(result.getString("nama_pemesan"), result.getString("kategori"));
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
                supplier = new Supplier(result.getString("nama_penyedia"));
                supplierList.add(supplier);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return supplierList;
    }

    public ArrayList<Transaction> getTransactionList() {
        transactionList = new ArrayList<>();
        try {
            int i = 1;
            Transaction transaction;
            ResultSet result = dbhelper.runQuery("select * from pesananATK join atk join pemesan");
            
            while (result.next()){
                transaction = new Transaction(new User(result.getString("nama_pemesan"), result.getString("kategori")), new ATK(result.getString("nama_atk"),0,0), result.getInt("jumlah"), new Date());
                transactionList.add(transaction);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transactionList;
    }

    public ArrayList<Order> getOrderList() {
        orderList = new ArrayList<>();
        try {
            int i = 1;
            Order order;
            ResultSet result = dbhelper.runQuery("select * from pengadaan join atk join penyedia");
            
            while (result.next()){
                order = new Order(new Supplier(result.getString("nama_penyedia")), new ATK(result.getString("nama_atk"), 0, 0), result.getInt("jumlah"), new Date());
                orderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderList;
    }
    
}

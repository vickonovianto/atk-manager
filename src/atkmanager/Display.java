/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atkmanager;

import java.util.ArrayList;

/**
 *
 * @author adinb
 */
public class Display {
    ArrayList<ATK> atkList;
    ArrayList<User> userList;
    ArrayList<Supplier> supplierkList;
    ArrayList<Transaction> transactionList;
    ArrayList<Order> orderList;

    public ArrayList<ATK> getAtkList() {
        return atkList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Supplier> getSupplierkList() {
        return supplierkList;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    
}

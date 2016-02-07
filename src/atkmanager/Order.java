package atkmanager;

import java.util.Date;

/**
 *
 * @author adinb
 */
public class Order {
    private Supplier supplier;
    private ATK atk;
    private int number;
    private Date orderDate;
    private Date receivedDate;

    public Order(Supplier supplier, ATK atk, int number, Date orderDate, Date receivedDate) {
        this.supplier = supplier;
        this.atk = atk;
        this.number = number;
        this.orderDate = orderDate;
        this.receivedDate = receivedDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ATK getAtk() {
        return atk;
    }

    public void setAtk(ATK atk) {
        this.atk = atk;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
}

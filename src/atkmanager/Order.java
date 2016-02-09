package atkmanager;

import java.util.Date;

/**
 *
 * @author adinb
 */
public class Order {
    private Supplier supplier;
    private ATK item;
    private int numbers;
    private Date receivedDate;

    public Order(Supplier supplier, ATK item, int number, Date receivedDate) {
        this.supplier = supplier;
        this.item = item;
        this.numbers = numbers;
        this.receivedDate = receivedDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ATK getItem() {
        return item;
    }

    public void setItem(ATK item) {
        this.item = item;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
}

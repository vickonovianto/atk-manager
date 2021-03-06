package atkmanager;

import java.util.Date;

/**
 *
 * @author adinb
 */
public class Transaction {
    User user;
    ATK item;
    int numbers;
    Date transactionDate;
    int status; // 0: normal, 1: booked, 2: taken

    public Transaction(User user, ATK item, int numbers, Date transactionDate, int status) {
        this.user = user;
        this.item = item;
        this.numbers = numbers;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date orderDate) {
        this.transactionDate = orderDate;
    }
    
    
}

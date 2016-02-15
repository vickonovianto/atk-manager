package atkmanager;

/**
 * Contains information for ATK
 * @author adinb
 */
public class ATK {
    private int ID;
    private String name;
    private int number;
    private int supplierID;

    public ATK(int ID, String name, int number, int supplierID) {
        this.ID = ID; 
        this.name = name;
        this.number = number;
        this.supplierID = supplierID;
    }
    
   public String[] toArray(){
       String[] arr = {name, Integer.toString(number)};
       return arr;
   }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getSupplierID() {
        return supplierID;
    }
    
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    
}

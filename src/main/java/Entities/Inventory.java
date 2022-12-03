package Entities;
import java.io.Serializable;
import java.util.HashMap;

public class Inventory implements Serializable {
    private int myMoney = 500;
    private int rent;
    private String name;
    private HashMap<String, Integer> myItems = new HashMap<>();

    public int getMyMoney() {
        return myMoney;
    }

    public void setName(String s) { name = s; }
    public String getName() { return name; }

    public void removeMoney(int amount) {
        myMoney -= amount;
    }

    public void addMoney(int amount){
        myMoney += amount;
    }

    public HashMap<String, Integer> getMyItems() {
        return myItems;
    }

    public void addItem(String item, int amount) {
        myItems.put(item, amount);
    }

    public void removeItem(Product item) {
        myItems.remove(item);
    }

    public void removeSome(String item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, present_amount - amount);
    }

    public void addAnotherItem(String item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, amount + present_amount);
    }

    public void increaseRent() { rent += 100; }

    public void removeRent() { myMoney -= rent; }

}

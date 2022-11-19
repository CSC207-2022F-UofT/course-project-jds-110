package entities;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private int myMoney;

    private HashMap<Product, Integer> myItems;

    public int getMyMoney() {
        return myMoney;
    }


    public void removeMoney(int amount) {
        myMoney -= amount;
    }

    public void addMoney(int amount){
        myMoney += amount;
    }

    public HashMap<Product, Integer> getMyItems() {
        return myItems;
    }

    public void addItem(Product item, int amount) {
        myItems.put(item, amount);
    }

    public void removeItem(Product item) {
        myItems.remove(item);
    }

    public void removeSome(Product item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, present_amount - amount);
    }

    public void addAnotherItem(Product item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, amount + present_amount);
    }



}

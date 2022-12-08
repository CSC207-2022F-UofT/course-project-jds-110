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


    /**
     * Remove money from my money
     * @param amount amount of money that the user pays
     */
    public void removeMoney(int amount) {
        myMoney -= amount;
    }

    /**
     * Add money to my money
     * @param amount amount of money that the user gets paid
     */
    public void addMoney(int amount){
        myMoney += amount;
    }


    public HashMap<String, Integer> getMyItems() {
        return myItems;
    }

    /**
     * Add items to the user's inventory
     * @param item String of items that the user wants to store in their inventory
     * @param amount the amount of the items
     */
    public void addItem(String item, int amount) {
        myItems.put(item, amount);
    }

    /**
     * Remove items from the user's inventory
     * @param item String of items that the user wants to get rid off from their inventory
     */
    public void removeItem(String item) {
        myItems.remove(item);
    }

    /**
     * Remove only some items in the inventory
     * @param item item the user wants to remove
     * @param amount number of items the user wants to remove
     */

    public void removeSome(String item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, present_amount - amount);
    }

    /**
     * Add another item if the item is already in the inventory
     * @param item the name of the item you want to store
     * @param amount the amount of the item
     */
    public void addAnotherItem(String item, int amount){
        int present_amount = myItems.get(item);
        myItems.put(item, amount + present_amount);
    }

    /**
     * Increase Rent by $100
     */
    public void increaseRent() { rent += 100; }

    /**
     * The user pays the rent
     */
    public void removeRent() { myMoney -= rent; }

    public int getRent() { return rent; }
}

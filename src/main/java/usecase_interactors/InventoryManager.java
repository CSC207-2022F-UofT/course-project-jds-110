package usecase_interactors;
import entities.Inventory;
import entities.Product;

import java.util.HashMap;

public class InventoryManager {
    private static int rent = 100;
    private static Inventory myInventory = new Inventory();

    private static String farmname;

    public static HashMap<Product, Integer> getMyInventoryItems() {
        return myInventory.getMyItems();
    }

    public static void setMyInventory(Inventory i) { myInventory = i; }

    public static Inventory getMyInventory() { return myInventory; }

    public static int getMyInventoryMoney() {
        return myInventory.getMyMoney();
    }

    public static void removeMoney(int amount) {
        myInventory.removeMoney(amount);
    }

    public static void addMoney(int amount){
        myInventory.addMoney(amount);
    }

    public static void setFarmname(String newname) {
        farmname = newname;
    }


    public static String getFarmname() {
        return farmname;
    }

    public static void addItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item)){
            myInventory.addAnotherItem(item, amount);
        }
        else {
            myInventory.addItem(item, amount);
        }
    }

    public static Boolean removeItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item)){
            if (myInventory.getMyItems().get(item) > 1){
                myInventory.removeSome(item, amount);
            } else {
                myInventory.removeItem(item);
            }
            return true;
        } else {
            return false;
        }
    }

    public static void increaseRent() { rent = 1000;}

    public static void removeRent() { myInventory.removeMoney(rent); }

}

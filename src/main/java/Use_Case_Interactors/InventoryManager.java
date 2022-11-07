package Use_Case_Interactors;
import Entities.Inventory;
import Entities.Product;

import java.util.HashMap;

public class InventoryManager {
    private static Inventory myInventory = new Inventory();

    public static HashMap<Product, Integer> getMyInventoryItems() {
        return myInventory.getMyItems();
    }

    public static int getMyInventoryMoney() {
        return myInventory.getMyMoney();
    }

    public static void removeMoney(int amount) {
        myInventory.removeMoney(amount);
    }

    public static void addMoney(int amount){
        myInventory.addMoney(amount);
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

}
package Use_Case_Interactors;
import Entities.BakedPotato;
import Entities.Inventory;
import Entities.Product;

import java.util.HashMap;

public class InventoryManager {

    private static HashMap<String, Product>productStringDictionary = new HashMap<>();

    private static Inventory myInventory;

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

    public static boolean checkIfAvailable(Product item, int amount){
        return myInventory.getMyItems().get(item) >= amount;
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

    public static void increaseRent() { myInventory.increaseRent(); }

    public static void removeRent() { myInventory.removeRent(); }

    public static void setName(String s) { myInventory.setName(s); }

    public static String getName(){return myInventory.getName(); }

    public static void setupProductStringDictionary(){
        // add BakedPotato, Chicken, Corn, CornCob, COw, Egg, Milk, Potato, RipeTomato, Sheep, Tomato, Wool
        productStringDictionary.put("BakedPotato", (Product) new BakedPotato());
        /// stilltodo
    }
}

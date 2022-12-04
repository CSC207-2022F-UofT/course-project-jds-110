package Use_Case_Interactors;
import Entities.*;
import Entities.Inventory;
import Entities.Product;

import java.util.HashMap;

public class InventoryManager {

    private static final HashMap<String, Product>productStringDictionary = new HashMap<>();

    private static Inventory myInventory = new Inventory();

    private static String farmname;

    public static HashMap<Product, Integer> getMyInventoryItems() {
        HashMap<Product, Integer>productHashmap = new HashMap<>();
        for (String i : myInventory.getMyItems().keySet()){
            productHashmap.put(productStringDictionary.get(i), myInventory.getMyItems().get(i));
        }
        return productHashmap;
        // return myInventory.getMyItems();
    }
    public static HashMap<String, Integer> getMyInventoryItemsString(){
        return myInventory.getMyItems();
    }

    public static void setMyInventory(Inventory i) { myInventory = i; }

    public static Inventory getMyInventory() { return myInventory; }

    public static int getMyInventoryMoney() {
        return myInventory.getMyMoney();
    }

    /**
     * Remove money from the user's inventory
     * @param amount the amount of money to pay off
     */
    public static void removeMoney(int amount) {
        myInventory.removeMoney(amount);
    }

    /**
     * Add money to the user's inventory
     * @param amount the amount of money to get paid
     */
    public static void addMoney(int amount){
        myInventory.addMoney(amount);
    }

    /**
     * Check if a certain number of product is available in the inventory
     * @param item An item that the user is requested
     * @param amount Number of products that the user requested
     * @return True if the product with the requested amount is available and false if not
     */
    public static boolean checkIfAvailable(Product item, int amount){

        return myInventory.getMyItems().get(item.getName()) >= amount;
    }

    /**
     * Add a certain number of items to the inventory
     * @param item items that the user wants to store in their inventory
     * @param amount number of items that the user wants to store in their inventory
     */
    public static void addItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item.getName())){
            myInventory.addAnotherItem(item.getName(), amount);
        }
        else {
            myInventory.addItem(item.getName(), amount);
        }
    }

    /**
     * Remove a certain amount of items from the inventory
     * @param item items that the user wants to remove from their inventory
     * @param amount number of items that the user wants to remove from in their inventory
     * @return
     */
    public static Boolean removeItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item.getName())){
            if (myInventory.getMyItems().get(item.getName()) > 1){
                myInventory.removeSome(item.getName(), amount);
            } else {
                myInventory.removeItem(item);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increase rent in the inventory
     */
    public static void increaseRent() { myInventory.increaseRent(); }


    /**
     * The user pays off rent from the inventory
     */
    public static void removeRent() { myInventory.removeRent(); }


    public static void setName(String s) { myInventory.setName(s); }

    public static String getName(){return myInventory.getName(); }


    //a method to reset inventory for use in EndGameConditions_UseCase_Test
    public static void reset() {
        myInventory = new Inventory();
    }

    /**
     * A dictionary that converts string to product
     */
    public static void setupProductStringDictionary(){
        // add BakedPotato, Chicken, Corn, CornCob, COw, Egg, Milk, Potato, RipeTomato, Sheep, Tomato, Wool
        productStringDictionary.put("BakedPotato",new BakedPotato());
        productStringDictionary.put("Chicken",new Chicken());
        productStringDictionary.put("Corn",new Corn());
        productStringDictionary.put("CornCob",new CornCob());
        productStringDictionary.put("Cow",new Cow());
        productStringDictionary.put("Egg(s)",new Egg());
        productStringDictionary.put("Milk",new Milk());
        productStringDictionary.put("Potato",new Potato());
        productStringDictionary.put("Sheep",new Sheep());
        productStringDictionary.put("Tomato",new Tomato());
        productStringDictionary.put("Wool",new Wool());
    }
    public static HashMap<String, Product> getProductStringDictionary() {
        return productStringDictionary;
    }
}

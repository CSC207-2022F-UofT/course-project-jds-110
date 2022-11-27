package Use_Case_Interactors;
import Entities.*;

import java.util.HashMap;

public class InventoryManager {

    private static final HashMap<String, Product>productStringDictionary = new HashMap<>();

    private static Inventory myInventory;

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

    public static void removeMoney(int amount) {
        myInventory.removeMoney(amount);
    }

    public static void addMoney(int amount){
        myInventory.addMoney(amount);
    }

    public static boolean checkIfAvailable(Product item, int amount){

        return myInventory.getMyItems().get(item.getName()) >= amount;
    }


    public static void addItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item.getName())){
            myInventory.addAnotherItem(item.getName(), amount);
        }
        else {
            myInventory.addItem(item.getName(), amount);
        }
    }

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

    public static void increaseRent() { myInventory.increaseRent(); }

    public static void removeRent() { myInventory.removeRent(); }

    public static void setName(String s) { myInventory.setName(s); }

    public static String getName(){return myInventory.getName(); }

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

        /// stilltodo
    }
}

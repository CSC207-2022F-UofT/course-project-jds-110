package use_case_interactors;
import entities.*;
import entities.nonyieldable.*;
import entities.yieldable.*;


import java.util.HashMap;

public class InventoryManager {

    private static final HashMap<String, Product>productStringDictionary = new HashMap<>();

    private static Inventory myInventory = new Inventory();

    public static HashMap<Product, Integer> getMyInventoryItems() {
        HashMap<Product, Integer>productHashmap = new HashMap<>();
        for (String i : myInventory.getMyItems().keySet()){
            productHashmap.put(convertStringtoProduct(i), myInventory.getMyItems().get(i));
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

        // also check if this is available at all
        return (myInventory.getMyItems().containsKey(item.getName()) & getMyInventoryItemsString().get(item.getName()) >= amount);
    }

    public static boolean checkIfAvailable(String stringItem, int amount){
        Product item = convertStringtoProduct(stringItem);
        // also check if this is available at all
        return (myInventory.getMyItems().containsKey(item.getName()) & getMyInventoryItemsString().get(item.getName()) >= amount);
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
     */
    public static void removeItem(Product item, int amount) {
        if (myInventory.getMyItems().containsKey(item.getName())) {
            if (myInventory.getMyItems().get(item.getName()) > 1) {
                myInventory.removeSome(item.getName(), amount);
            } else {
                myInventory.removeItem(item.getName());
            }
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

    public static Product convertStringtoProduct(String item){
        return productStringDictionary.get(item);
    }

    public static void setupProductStringDictionary(){
        // add BakedPotato, Chicken, Corn, CornCob, Cow, Egg, Milk, Potato, RipeTomato, Sheep, Tomato, Wool
        productStringDictionary.put("bakedpotato",new BakedPotato());
        productStringDictionary.put("chicken",new Chicken());
        productStringDictionary.put("corn",new Corn());
        productStringDictionary.put("corncob",new CornCob());
        productStringDictionary.put("cow",new Cow());
        productStringDictionary.put("egg",new Egg());
        productStringDictionary.put("milk",new Milk());
        productStringDictionary.put("potato",new Potato());
        productStringDictionary.put("sheep",new Sheep());
        productStringDictionary.put("tomato",new Tomato());
        productStringDictionary.put("ripetomato",new RipeTomato());
        productStringDictionary.put("wool",new Wool());
    }

    public static String createPriceList(){
        return "bakedpotato = $10 \n chicken = $10 \n corn = $5 \n corncob = $10 \n cow = $30 \n" +
                " egg = $1 \n milk = $3 \n potato = $7 \n ripetomato = $1 \n sheep = $100 \n tomato = $3 \n wool = $12";
    }

    public static HashMap<String, Product> getProductStringDictionary() {
        return productStringDictionary;

    }

    public static int getRent() { return myInventory.getRent(); }
}

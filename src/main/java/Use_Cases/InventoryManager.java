package Use_Cases;
import Entities.Inventory;
import Entities.Product;

import java.util.ArrayList;

public class InventoryManager {
    private static Inventory myInventory = new Inventory();

    public static ArrayList<Product> getMyInventoryItems() {
        return myInventory.getMyItems();
    }

    public static int getMyInventoryMoney() {
        return myInventory.getMyMoney();
    }

    public static void addItem() {
        // TO DO
        return;
    }

    public static Boolean removeItem() {
        // TO DO
        return true;
    }

}

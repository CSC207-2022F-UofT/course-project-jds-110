package Action_Classes;
import Data_Classes.Inventory;
import Data_Classes.Products;

import java.util.ArrayList;

public class InventoryManager {
    private Inventory myInventory;

    public ArrayList<Products> getMyInventoryItems() {
        return myInventory.getMyItems();
    }

    public int getMyInventoryMoney() {
        return myInventory.getMyMoney();
    }

    public void addItem() {
        // TO DO
        return;
    }

    public Boolean removeItem() {
        // TO DO
        return true;
    }

}
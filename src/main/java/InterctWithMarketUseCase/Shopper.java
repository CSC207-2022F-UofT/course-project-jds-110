package InterctWithMarketUseCase;

import Entities.Yieldable;
import Use_Case_Interactors.InventoryManager;
import Entities.Product;
import Use_Case_Interactors.PlotManager;

public class Shopper {


    public static boolean sell_to_market(Product item, Integer quantity){

        boolean valid = check_valid_sale(item, quantity);

        if (!valid){
            return false;
        }

        int comp = item.getValue() * quantity;

        InventoryManager.addMoney(comp);

        InventoryManager.removeItem(item, quantity);

        return true;
    }

    public static boolean buy_from_market(Product item, Integer quantity){
        boolean valid = check_valid_purchase(item, quantity);

        if (!valid){
            return false;
        }

        int comp = item.getValue() * quantity;

        InventoryManager.removeMoney(comp);

        InventoryManager.addItem(item, quantity);

        return true;
    }

    public static boolean buy_plot(){
        int comp = PlotManager.getPlotValue();

        if (InventoryManager.getMyInventoryMoney() < comp){
            return false;
        }

        PlotManager.createNewPlot();
        InventoryManager.removeMoney(comp);
        return true;
    }

    private static boolean check_valid_purchase(Product item, Integer quantity){
        return (!(item instanceof Yieldable) & InventoryManager.getMyInventoryMoney() >= item.getValue() * quantity);
    }

    private static boolean check_valid_sale(Product item, Integer quantity){
        return ((item instanceof Yieldable) & InventoryManager.checkIfAvailable(item, quantity));
    }
}
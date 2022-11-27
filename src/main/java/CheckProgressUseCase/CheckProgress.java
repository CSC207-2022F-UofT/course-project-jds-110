package CheckProgressUseCase;

import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.CheckProgressBoundary;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * CheckProgress Class is the main use case class for the CheckProgressUseCase. It fetches user's
 * information.
 */
public class CheckProgress {
    /**
     * gameProgress() fetches the user's inventory, plots, and money
     */
    public static void gameProgress () {
        HashMap<Product, Integer> inventory = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        CheckProgressBoundary.boundaryOutput(inventory, plots, money);
    }
}

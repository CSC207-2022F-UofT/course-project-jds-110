package CheckProgress;

import CheckProgressUseCase.CheckProgressPresenter;
import Entities.*;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CheckProgressTest tests various parts of the CheckProgress use case.
 */
public class CheckProgressTest {
    Product egg = new Egg();
    Inventory i = new Inventory();

    /**
     * Initialize inventory and plots with contents.
     */
    @Before
    public void addStuff(){
        InventoryManager.setMyInventory(i);
        InventoryManager.setupProductStringDictionary();
        InventoryManager.addItem(egg, 5);
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
    }


    /**
     * CheckProgressPresenterNoMutationTest tests that the presenter does not mutate user's money,
     * inventory and plots.
     */
    @Test(timeout = 50)
    public void CheckProgressPresenterNoMutationTest() {
        HashMap<Product, Integer> inventoryMap = InventoryManager.getMyInventoryItems();
        HashMap<Product, Integer> copyInventoryMap = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        ArrayList<Plot> copyPlots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        int copyOfMoney = InventoryManager.getMyInventoryMoney();
        boolean actual;
        boolean expected = true;
        CheckProgressPresenter.transformProgress(inventoryMap, plots, money);
        boolean actual1 = false;
        if (inventoryMap.size() == copyInventoryMap.size()) {
            actual1 = inventoryMap.equals(copyInventoryMap);
        }
        boolean actual2 = plots.equals(copyPlots);
        boolean actual3 = money == copyOfMoney;

        actual = actual1 == actual2 == actual3;

        Assertions.assertEquals(expected, actual);
    }

    /*
     * No test for CheckProgressPresenter for String conversion because there's no way to track the information
     * that gets manipulated in the transformProgress() method.
     */

    /*
     * No test for CheckProgressController because it makes a subroutine call to the CheckProgress use case boundary.
     */

    /*
     * No test for CheckProgressView because it prints separate multi-line messages.
     */

    /*
     * No test for CheckProgress because it just calls InventoryManager and PlotManager to fetch information.
     */


}

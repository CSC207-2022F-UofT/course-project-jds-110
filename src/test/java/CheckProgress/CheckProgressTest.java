package CheckProgress;

import CheckProgressUseCase.CheckProgress;
import CheckProgressUseCase.CheckProgressController;
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
        PlotManager.place(egg, 0);
    }

    /**
     * CheckProgressNoMutationTest tests that transformProgress() does not mutate user's money,
     * inventory and plots.
     */
    @Test
    public void CheckProgressNoMutationTest() {
        HashMap<Product, Integer> inventoryMap = InventoryManager.getMyInventoryItems();
        HashMap<Product, Integer> copyInventoryMap = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        ArrayList<Plot> copyPlots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        int copyOfMoney = InventoryManager.getMyInventoryMoney();
        boolean actual;
        boolean expected = true;
        String info = CheckProgress.transformProgress(inventoryMap, plots, money);
        boolean actual1 = false;
        if (inventoryMap.size() == copyInventoryMap.size()) {
            actual1 = inventoryMap.equals(copyInventoryMap);
        }
        boolean actual2 = plots.equals(copyPlots);
        boolean actual3 = money == copyOfMoney;
        System.out.println(info);

        actual = actual1 == actual2 == actual3;

        Assertions.assertEquals(expected, actual);
    }
    /**
     * CheckProgressStringTest tests that the string containing the user's information matches their actual information
     * and that the format of the string is correct.
     */
    @Test
    public void CheckProgressStringTest() {
        String expected = "Inventory:" + "\n" + "-------------------" + "\n" + "egg: 5" + "\n" +
                "-------------------" + "\n" + "Plots:" + "\n" + "-------------------" + "\n" + "Plot 1: egg | 0 day(s) left."
                + "\n" + "-------------------" + "\n" + "Money: $500";
        String actual = CheckProgressController.gameProgress();
        Assertions.assertEquals(expected, actual);
    }

    /*
     * No test for CheckProgressController because it makes a subroutine call to the CheckProgress use case.
     */
}

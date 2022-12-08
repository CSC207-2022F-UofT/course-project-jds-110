package check_progress_test;

import entities.Inventory;
import entities.Plot;
import entities.Product;
import entities.yieldable.Egg;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import use_cases.check_progress_use_case.CheckProgress;
import use_cases.check_progress_use_case.CheckProgressController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * CheckProgressTest tests various parts of the check_progress_test use case.
 */
public class CheckProgressTest {
    final Product egg = new Egg();
    final Inventory i = new Inventory();

    /**
     * Initialize inventory and plots with contents.
     */
    @BeforeEach
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
    public void CheckProgressNoMutationInventory() {
        HashMap<Product, Integer> initial = InventoryManager.getMyInventoryItems();
        HashMap<Product, Integer> actual = InventoryManager.getMyInventoryItems();
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        int money = InventoryManager.getMyInventoryMoney();
        CheckProgress.transformProgress(initial, plots, money);
        Assertions.assertEquals(initial, actual);
    }

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
        String expected = "Inventory:" + "\n" + "-------------------" + "\n" + "egg: 4" + "\n" +
                "-------------------" + "\n" + "Plots:" + "\n" + "-------------------" + "\n" + "Plot 0: egg | 0 day(s) left."
                + "\n" + "-------------------" + "\n" + "Money: $500";
        String actual = CheckProgressController.gameProgress();
        Assertions.assertEquals(expected, actual);
    }

    /*
     * No test for CheckProgressController because it makes a subroutine call to the check_progress_test use case.
     */
}

package share_usecase_test;

import entities.*;
import entities.nonyieldable.*;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.share_use_case.ShareController;

import java.util.ArrayList;

public class ShareControllerTest {

    @BeforeEach
    public void setup() {
        Inventory i = new Inventory();
        InventoryManager.setMyInventory(i);
        InventoryManager.setName("Player");
        // note: inventories are initialized with $500 so Player has $500
        ArrayList<Plot> newPlots = new ArrayList<>();
        PlotManager.setMyPlots(newPlots);
        // essentially resetting plots
    }


    /**
     * Test if the Farm Appearance will be an empty ArrayList if there are
     * no plots.
     */
    @Test
    public void testGetFarmAppearanceEmpty() {
        Assertions.assertEquals(0, ShareController.displayFarm().size());
    }

    /**
     * Test if Farm Appearance will properly be an ArrayList of
     * the products on the plots
     */
    @Test
    public void testGetFarmAppearanceNonEmpty() {
        ArrayList<Plot> currPlots = new ArrayList<>();

        Plot plot1 = new Plot(1);
        Product potato = new Potato();
        plot1.place(potato);

        Plot plot2 = new Plot(2);
        Product tomato = new Tomato();
        plot2.place(tomato);

        currPlots.add(plot1);
        currPlots.add(plot2);
        PlotManager.setMyPlots(currPlots);

        ArrayList<String> expectedArrayList = new ArrayList<>();

        expectedArrayList.add("potato");
        expectedArrayList.add("tomato");

        Assertions.assertEquals(expectedArrayList, ShareController.displayFarm());
    }

    /**
     * Test if an empty plot will be indicated with an empty string
     * in DisplayFarm
     */
    @Test
    public void testDisplayFarmWithEmptyPlot() {
        ArrayList<Plot> currPlots = new ArrayList<>();

        Plot plot1 = new Plot(1);
        Product potato = new Potato();
        plot1.place(potato);

        Plot plot2 = new Plot(2);

        currPlots.add(plot1);
        currPlots.add(plot2);
        PlotManager.setMyPlots(currPlots);

        ArrayList<String> expectedArrayList = new ArrayList<>();

        expectedArrayList.add("potato");
        expectedArrayList.add("");

        Assertions.assertEquals(expectedArrayList, ShareController.displayFarm());
    }
}

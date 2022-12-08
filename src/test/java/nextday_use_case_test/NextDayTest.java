package nextday_use_case_test;

import entities.*;
import entities.nonyieldable.Chicken;
import entities.nonyieldable.Corn;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import use_cases.nextday_use_case.NextDay;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class NextDayTest {
    /** Before each test cases,
     * set up a new Inventory and an arraylist for containing plots.
     * Also, create a new plot to use.
     * */
    @BeforeEach
    public void setup() {
        InventoryManager.setMyInventory(new Inventory());
        PlotManager.setMyPlots(new ArrayList<>());
        PlotManager.createNewPlot();
    }

    /** Test that nextDayInventory method removes rent properly */
    @Test
    public void testNextDayInventory() {
        NextDay.nextDayInventory();
        Assertions.assertEquals(InventoryManager.getMyInventoryMoney(), 400);
    }

    /** Test that nextDayPlot method does not increase progress on empty plots */
    @Test
    public void testNextDayPlotEmpty() {
        NextDay.nextDayPlots();
        Plot p = (PlotManager.getMyPlots()).get(0);
        Assertions.assertEquals(p.getDaysLeftToHarvest(), 0);
    }

    /** Test that nextDayPlot method increases progress
     * on non-empty plots with a non-ripe product
     * */
    @Test
    public void testNextDayPlotNotRipe() {
        PlotManager.place(new Chicken(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        int exp = p.getDaysLeftToHarvest()-1;
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        Assertions.assertEquals(exp, act);
    }

    /** Test that nextDayPlot method reset growing time
     * on non-empty plots with a ripe animal
     * */
    @Test
    public void testNextDayPlotRipeAnimal() {
        PlotManager.place(new Chicken(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        p.setDaysLeftToHarvest(0);
        int exp = (new Chicken()).getDaysToYield();
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        Assertions.assertEquals(exp, act);
    }

    /** Test that nextDayPlot method empties the crop
     * on non-empty plots with a ripe crop
     * */
    @Test
    public void testNextDayPlotRipeCrop() {
        PlotManager.place(new Corn(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        p.setDaysLeftToHarvest(0);
        NextDay.nextDayPlots();
        Assertions.assertTrue(p.isEmpty());
    }

}

/* No test for nextDayEndgame method
since the only thing it did is to call endGame method in EndgameConditions class
which will be tested in EndgameConditions Use Case

No test for nextDayRandomEvent method
since the random event occurs randomly which is hard to be tested
*/

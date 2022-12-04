package nextday_use_case;

import Entities.*;
import Use_Case_Interactors.InventoryManager;
import org.junit.*;
import Use_Case_Interactors.PlotManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NextDayTest {
    @BeforeEach
    public void setup() {
        /* set up a new Inventory */
        Inventory i = new Inventory();
        InventoryManager.setMyInventory(i);
        /* set up an arraylist for containing plots and create a new plot */
        ArrayList<Plot> p = new ArrayList<>();
        PlotManager.setMyPlots(p);
        PlotManager.createNewPlot();
    }

    /* Test that nextDayInventory method removes rent properly */
    @Test
    public void testNextDayInventoryBefore() {
        NextDay.nextDayInventory();
        assertEquals(InventoryManager.getMyInventoryMoney(), 400);
    }

    /* Test nextRandomEvent method */
    @Test
    public void testNextDayRandomEvents() {
        //TODO
    }

    /* Test that nextDayPlot method does not increase progress on empty plots */
    @Test
    public void testNextDayPlotEmpty() {
        NextDay.nextDayPlots();
        Plot p = (PlotManager.getMyPlots()).get(0);
        assertEquals(p.getDaysLeftToHarvest(), 0);
    }

    /* Test that nextDayPlot method increases progress on non-empty plots with a non-ripe product */
    @Test
    public void testNextDayPlotNotRipe() {
        PlotManager.place(new Chicken(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        int exp = p.getDaysLeftToHarvest()-1;
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        assertEquals(exp, act);
    }

    /* Test that nextDayPlot method reset growing time on non-empty plots with a ripe animal */
    @Test
    public void testNextDayPlotRipeAnimal() {
        PlotManager.place(new Chicken(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        p.setDaysLeftToHarvest(0);
        int exp = (new Chicken()).getDaysToYield();
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        assertEquals(exp, act);
    }

    /* Test that nextDayPlot method empties the crop on non-empty plots with a ripe crop */
    @Test
    public void testNextDayPlotRipeCrop() {
        PlotManager.place(new Corn(), 0);
        Plot p = (PlotManager.getMyPlots()).get(0);
        p.setDaysLeftToHarvest(0);
        NextDay.nextDayPlots();
        assertTrue(p.isEmpty());
    }
}

/* No test for nextDayEndgame method
since the only thing it did is to call endGame method in EndgameConditions class
which will be tested in EndgameConditions Use Case
*/

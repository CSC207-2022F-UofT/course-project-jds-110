package nextday_use_case;

import entities.Chicken;
import entities.Inventory;
import entities.Plot;
import org.junit.Test;
import use_case_interactors.PlotManager;

import static org.junit.Assert.assertEquals;

public class NextDayTest {
    /* Test that nextDayInventory method removes rent properly */
    @Test
    public void testNextDayInventory() {
        Inventory a = new Inventory();
        NextDay.nextDayInventory();
        // assertion
        assertEquals(a.getMyMoney(), 400);
    }

    /* Test nextRandomEvent method */
    @Test
    public void testNextDayRandomEvents() {
        //TODO
    }

    /* Test that nextDayPlot method does not increase progress on empty plots */
    @Test
    public void testNextDayPlotEmpty() {
        PlotManager.createNewPlot();
        NextDay.nextDayPlots();
        Plot p = PlotManager.getMyPlots().get(0);
        // assertion
        assertEquals(p.getDaysLeftToHarvest(), 0);
    }

    /* Test that nextDayPlot method increases progress on non-empty plots */
    @Test
    public void testNextDayPlotNonEmpty() {
        PlotManager.createNewPlot();
        Plot p = PlotManager.getMyPlots().get(0);
        p.place(new Chicken());
        int exp = p.getDaysLeftToHarvest()-1;
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        // assertion
        assertEquals(exp, act);
    }

    /* Test that nextDayPlot method resets growing time of the product,
     when it is ripe and player forgot to harvest the yield so the yield spoils */
    @Test
    public void testNextDayPlotSpoil() {
        PlotManager.createNewPlot();
        Plot p = PlotManager.getMyPlots().get(0);
        p.place(new Chicken());
        int exp = p.getDaysLeftToHarvest();
        p.setDaysLeftToHarvest(0);
        NextDay.nextDayPlots();
        int act = p.getDaysLeftToHarvest();
        // assertion
        assertEquals(exp, act);
    }

    /* Test nextDayEndGame method */
    @Test
    public void testNextDayEndGame() {
        //TODO
    }
}

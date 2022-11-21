package use_case_interactors;
import entities.Inventory;
import entities.Plot;

import java.util.ArrayList;

public class PlotManager {
    private static ArrayList<Plot> myPlots = new ArrayList<>();

    public static void setMyPlots(ArrayList<Plot> arr) { myPlots = arr; }

    public static ArrayList<Plot> getMyPlots() {
        return myPlots;
    }

    public static void createNewPlot(){
        int newPlotId = myPlots.size() - 1;
        myPlots.add(new Plot(newPlotId));
        InventoryManager.increaseRent();
        // create a new plot instance and add it to myPLOTS
    }
}

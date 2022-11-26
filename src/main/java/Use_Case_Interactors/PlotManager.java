package usecase_interactors;
import entities.Plot;

import java.util.ArrayList;

public class PlotManager {
    private static ArrayList<Plot> myPlots;

    public static void setMyPlots(ArrayList<Plot> arr) { myPlots = arr; }

    public static ArrayList<Plot> getMyPlots() {
        return myPlots;
    }



    public static int getPlotValue(){
        return Plot.getValue();
    }


    public static void createNewPlot(){
        int newPlotId = myPlots.size() - 1;
        myPlots.add(new Plot(newPlotId));
        InventoryManager.increaseRent();
        // create a new plot instance and add it to myPLOTS
    }

}

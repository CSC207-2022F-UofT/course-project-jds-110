package Use_Cases;
import Entities.Plot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlotManager {
    private static ArrayList<Plot> myPlots = new ArrayList<>();

    public static ArrayList<Plot> getMyPlots() {
        return myPlots;
    }

    public static void addPlot(){
        // TO DO
    }

    public static void createNewPlot(){
        int newPlotId = myPlots.size() - 1;
        myPlots.add(new Plot(newPlotId));
        // create a new plot instance and add it to myPLOTS
    }
}

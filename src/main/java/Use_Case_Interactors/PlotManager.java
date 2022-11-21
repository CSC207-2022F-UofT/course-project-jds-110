package Use_Case_Interactors;
import Entities.Plot;
import Entities.Product;

import java.util.ArrayList;

public class PlotManager {
    private static ArrayList<Plot> myPlots = new ArrayList<>();
    public static void setMyPlots(ArrayList<Plot>arr){myPlots = arr;}
    public static ArrayList<Plot> getMyPlots() {return myPlots;
    }

    public static void addPlot(){
        // TODO
    }

    public static void createNewPlot(){
        int newPlotId = myPlots.size() - 1;
        myPlots.add(new Plot(newPlotId));
        // create a new plot instance and add it to myPLOTS
    }

    public static int getPlotValue() {
        return Plot.getValue();
    }

    public static void harvest(Plot plot){
        plot.harvest();
    }

    public void startGrowing(Product product){
        product.getDaysToYield();
    }

    public String showProgress(Plot plot){
        System.out.println();
    }
}

package Action_Classes;
import Data_Classes.Plot;
import Data_Classes.Products;

import java.io.Serializable;
import java.util.ArrayList;

public class PlotManager implements Serializable {
    private static ArrayList<Plot> myPlots;

    public ArrayList<Plot> getMyPlots() {
        return myPlots;
    }

    public void addPlot(){
        // TO DO
    }
}

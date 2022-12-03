package Use_Case_Interactors;
import Entities.Animal;
import Entities.Crop;
import Entities.Plot;
import Entities.Product;

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
        int newPlotId = myPlots.size() + 1; // changed the size from -1 to +1
        myPlots.add(new Plot(newPlotId));
        InventoryManager.increaseRent();
        // create a new plot instance and add it to myPLOTS
    }

    public void startGrowing(Product product){product.getDaysToYield();
    }

    public void harvest(Plot plot) {
        if (plot.getProduct() instanceof Crop){
            Crop crop = (Crop) plot.getProduct();
            InventoryManager.addItem(crop, 1); ////addItem{Product, int}
            plot.emptyPlot(); //empty the plot
            System.out.println("You have saved your yields to your inventory!");}
    }

    public void extract(Plot plot){
        if (plot.getProduct() instanceof Animal){
            Animal animal = (Animal) plot.getProduct();
            InventoryManager.addItem(animal, 1);
            System.out.println("You have saved your yields to your inventory!");}
    }

    public static boolean place(Product product, int plotId){
        Plot plot = myPlots.get(plotId);
        if (plot.isEmpty()){
            return false;
        }
        else{
            plot.place(product);
            return true;
        }
    }

}

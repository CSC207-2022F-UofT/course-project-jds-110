package Entities;

import java.io.Serializable;

public class Plot implements Serializable {

    private int daysLeftToHarvest;
    private static Product productOnPlot;

    private int plotId;

    private static int value = 100;

    public Plot(int plotID){
        plotId = plotID;
    }

    public boolean isEmpty(){return productOnPlot == null;}

    public String getProductName(){
        if (productOnPlot == null){
            return ("no product");
        }
        return productOnPlot.getName();
    }
    public int getDaysLeftToHarvest() {
        return daysLeftToHarvest;
    }

    public void incrementProgress() {
        daysLeftToHarvest -= 1;
    }

    public void place(Product product){
        daysLeftToHarvest = product.getDaysToYield();
        productOnPlot = product;
    }

    public static int getValue() {
        return value;
    }

    public void emptyPlot(){
        productOnPlot =  null;
        daysLeftToHarvest = 0;
    }

    public static Product getProduct(){return productOnPlot;}
}

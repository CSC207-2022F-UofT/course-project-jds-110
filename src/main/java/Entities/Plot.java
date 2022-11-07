package Entities;

public class Plot {

    private int daysLeftToHarvest;
    private Product productOnPlot;

    private int plotId;

    public Plot(int plotID){
        plotId = plotID;
    }

    public boolean isEmpty(){return productOnPlot == null;}

    public String getProductName(){return productOnPlot.getName();}
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

    public String harvest() {
        // TO DO
        String s = "";
        return s;
    }


}

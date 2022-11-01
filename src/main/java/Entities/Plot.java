package Entities;

public class Plot {

    private int daysLeftToHarvest;
    private Product productOnPlot;

    public boolean isEmpty(){return productOnPlot == null;}

    public String getProductName(){return productOnPlot.getName();}
    public int getDaysLeftToHarvest() {
        return daysLeftToHarvest;
    }

    public void incrementProgress() {
        // TO DO
    }

    public void place(){
        // TO DO
    }

    public String harvest() {
        // TO DO
        String s = "";
        return s;
    }


}

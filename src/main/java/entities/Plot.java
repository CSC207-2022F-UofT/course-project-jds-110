package entities;

import use_case_interactors.InventoryManager;

public class Plot {

    private int daysLeftToHarvest;
    private Product productOnPlot;

    private int plotId;

    public Plot(int plotID){
        plotId = plotID;
    }

    public boolean isEmpty(){return productOnPlot == null;}

    public String getProductName(){return productOnPlot.getName();}

    public int getPlotId() { return plotId; }
    public Product getProductOnPlot() { return productOnPlot; }

    public void setDaysLeftToHarvest(int i) { daysLeftToHarvest = i; }

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

    public Product harvest() {
        /* reset days left to harvest when the yield has been harvest */
        daysLeftToHarvest = productOnPlot.getDaysToYield();
        return productOnPlot.getYield();
    }


}

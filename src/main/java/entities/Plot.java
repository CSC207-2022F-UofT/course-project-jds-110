package entities;

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
        daysLeftToHarvest = ((Yieldable) product).getDaysToYield();
        productOnPlot = product;
    }

    public Product harvest() {
        return ((Yieldable) productOnPlot).getYield();
    }


}

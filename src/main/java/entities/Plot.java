package entities;

import java.io.Serializable;

public class Plot implements Serializable {

    private int daysLeftToHarvest;
    private Product productOnPlot;

    private final int plotId;

    private static final int value = 100;

    public Plot(int plotID){plotId = plotID;
    }

    /**
     * Get id of plot
     * @return id of plot
     */
    public int getPlotId(){
        return plotId;
    }


    /**
     * Check if the plot is empty
     * @return Yes or no
     */
    public boolean isEmpty(){return productOnPlot == null;}

    /**
     * Get the string of products' names
     * @return names of the plots
     */
    public String getProductName(){
        if (productOnPlot == null){
            return ("no product");
        }
        return productOnPlot.getName();
    }

    /**
     * Return days left to harvest
     * @return the days left to harvest
     */
    public int getDaysLeftToHarvest() {
        return daysLeftToHarvest;
    }

    /**
     * Record the progress of the plot before harvest
     */
    public void incrementProgress() {
        daysLeftToHarvest -= 1;
    }

    /**
     * Place a product on a plot
     * @param product a product you want to place on the plot
     */
    public void place(Product product){
        daysLeftToHarvest = product.getDaysToYield();
        productOnPlot = product;
    }
    public void remove(){
        productOnPlot = null;
    }

    public static int getValue() {
        return value;
    }

    /**
     * Empty a plot after harvest
     */
    public void emptyPlot(){
        productOnPlot =  null;
        daysLeftToHarvest = 0;
    }

    public Product getProduct(){return productOnPlot;}

    public void setDaysLeftToHarvest(int i) { daysLeftToHarvest = i;
    }
}

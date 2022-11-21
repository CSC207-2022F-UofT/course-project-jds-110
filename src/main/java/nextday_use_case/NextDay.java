package nextday_use_case;

import EndGameConditions_UseCase.EndgameConditions;
import entities.Plot;
import entities.Product;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

public class NextDay {
    public static void nextDayInventory() {
        /* Remove rent from inventory */
        InventoryManager.removeRent();
        System.out.println("Rent is removed.");
    }

    public static void nextDayRandomEvents() {
        // TODO
    }

    public static void nextDayPlots() {
        for (Plot p : PlotManager.getMyPlots()) {
            /* If the plot is not empty, then increasing the progress of the product */
            if (!p.isEmpty()) {
                if (p.getDaysLeftToHarvest() == 0) {
                    /* The product is ripe but the yield has not been harvested, then the yield spoils.
                    Reset days left to harvest on the plot so that
                    the product goes back to growing and producing yield
                    */
                    Product product = p.getProductOnPlot();
                    p.setDaysLeftToHarvest(product.getDaysToYield());
                    /* Tell the player that the yield spoils */
                    System.out.printf("%s produced in Plot %d spoils since you didn't harvest it.%n",
                    (product.getYield()).getName(), p.getPlotId());
                }
                else{ /* Otherwise, increasing the progress of the product */
                    p.incrementProgress();
                }
            }
        }
    }

    public static void nextDayEndgame() {
        /* Check Endgame Condition to decide whether the game is finished or not */
        EndgameConditions.endGame();
        //TODO
    }
}
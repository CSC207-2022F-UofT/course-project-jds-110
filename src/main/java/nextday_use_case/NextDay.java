package nextday_use_case;

import EndGameConditions_UseCase.EndgameConditions;
import Entities.Animal;
import Entities.Crop;
import Entities.Plot;
import Entities.Product;
import Use_Case_Interactors.InventoryManager;
import Use_Case_Interactors.PlotManager;

public class NextDay {
    /** Remove rent from inventory */
    public static void nextDayInventory() {
        InventoryManager.removeRent();
    }

    public static void nextDayRandomEvents() {
        // TODO
    }

    /** Increasing the progress of the product on plot when it is non-empty.
     * When product is ripe but the yield has not been harvested,
     * then the yield spoils and something happens on plots
     * This progress will be shown in the helper method.
     * Otherwise, increase the progress of the product.
     **/
    public static void nextDayPlots() {
        for (Plot p : PlotManager.getMyPlots()) {
            if (!p.isEmpty()) {
                if (p.getDaysLeftToHarvest() == 0) {
                    spoil(p);
                } else {
                    p.incrementProgress();
                }
            }
        }
    }

    /** A helper method for nextDayPlots() to make different progresses
     *  for animal and crop when the product is ripe.
     *  For crop, it disappears when it is ripe.
     *  For animal, it goes back to growing and producing yield
     *  so the days left to harvest on the plot is reset.
     */
    private static void spoil(Plot p) {
        Product product = p.getProduct();
        if (product instanceof Crop) {
            p.emptyPlot();
        } else if (product instanceof Animal) {
            p.setDaysLeftToHarvest(product.getDaysToYield());
        }
    }

    /** Check Endgame Condition to decide whether the game is finished or not */
    public static String nextDayEndgame() {
        return EndgameConditions.endGame();
    }
}
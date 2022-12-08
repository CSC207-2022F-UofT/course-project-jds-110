package use_cases.nextday_use_case;

import use_cases.endgame_conditions_use_case.EndgameConditions;
import entities.nonyieldable.Animal;
import entities.Crop;
import entities.Plot;
import entities.Product;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;
import use_cases.random_events_use_case.RandomEvents;

public class NextDay {
    /**
     * Remove rent from inventory
     */
    public static void nextDayInventory() {
        InventoryManager.removeRent();
    }

    /**
     * Check whether there random events happens or not.
     * If so, it needed a message to inform the player about it.
     */
    public static String nextDayRandomEvents() {
        RandomEvents r = new RandomEvents();
        r.calculate_events();
        String event = r.getEvent();
        if (!event.equals("")) {
            return ("EVENT!!! You were struck by " + event + " .\n" +
                    "Check up on your Inventory and Plots to see how you may have been affected");
        }
        return "";
    }

    /**
     * Increasing the progress of the product on plot when it is non-empty.
     * When product is ripe but the yield has not been harvested,
     * then the yield spoils and something happens on plots
     * This progress will be shown in the helper method.
     * Otherwise, increase the progress of the product.
     **/
    public static String nextDayPlots() {
        for (Plot p : PlotManager.getMyPlots()) {
            if (!p.isEmpty()) {
                if (p.getDaysLeftToHarvest() == 0) {
                    spoil(p);
                    return "YIELDS SPOIL!!! You forgot to harvest some ripe products.\n" +
                            "Check up on your Plots to see what happened.";
                } else {
                    p.incrementProgress();
                }
            }
        }
        return "";
    }

    /**
     * A helper method for nextDayPlots() to make different progresses
     * for animal and crop when the product is ripe.
     * For crop, it disappears when it is ripe.
     * For animal, it goes back to growing and producing yield
     * so the days left to harvest on the plot is reset.
     */
    private static void spoil(Plot p) {
        Product product = p.getProduct();
        if (product instanceof Crop) {
            p.emptyPlot();
        } else if (product instanceof Animal) {
            p.setDaysLeftToHarvest(product.getDaysToYield());
        }
    }

    /**
     * Check Endgame Condition to decide whether the game is finished or not
     */
    public static String nextDayEndgame() {
        return EndgameConditions.endGame();
    }
}
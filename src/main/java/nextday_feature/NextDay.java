package nextday_feature;

import EndGameConditions_UseCase.EndgameConditions;
import entities.Plot;
import use_case_interactors.InventoryManager;
import use_case_interactors.PlotManager;

public class NextDay {
    public static void nextDayInventory() {
        /* Remove rent from inventory */
        InventoryManager.removeRent();

        /* Add yields to inventory if products are ripe */
        for (Plot p : PlotManager.getMyPlots()) {
            if (p.getDaysLeftToHarvest() == 0) {
                InventoryManager.addItem(p.harvest(), 1);
            }
        }
    }

    public static void nextDayRandomEvents() {
        // TODO
    }

    public static void nextDayPlots() {
        /* Increase the progress of the product in each plot */
        for (Plot p : PlotManager.getMyPlots()) {
            p.incrementProgress();
        }
    }

    public static void nextDayEndgame() {
        /* Check Endgame Condition to decide whether the game is finished or not */
        EndgameConditions.endGame();
    }
}

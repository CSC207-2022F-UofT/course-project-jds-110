package share_use_case;

import Entities.Plot;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;

public class Sharer {

    /**
     * @return The Crops or Animals on the player's plots (in emojis).
     * Example: if they only have 2 plots with a tomato and potato planted (in that order),
     * the ArrayList returned would be [tomato.png, potato.png]
     */

    public static ArrayList<String> getFarmAppearance() {

        ArrayList<Plot> plots = PlotManager.getMyPlots();

        ArrayList<String> farmNames = new ArrayList<>();
        for (Plot p : plots) {
            if (p.isEmpty()){
                farmNames.add("");
            }
            else {
            String type = p.getProductName();
//            String imageLocation = emojis.get(type);
                farmNames.add(type);
            }
        }

        if (plots.size() == 0) {
            farmNames.add("");
        }
        return farmNames;
    }

}

package Use_Case_Interactors;

import CheckProgressUseCase.CheckProgress;
import CheckProgressUseCase.CheckProgressPresenter;
import Entities.Plot;
import Entities.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckProgressBoundary implements UseCaseInteractorBoundary {
    /**
     * Calls the gameProgress() method in State to find information on the user's
     * inventory, plots and money.
     */
    public static void boundaryInput() {
        CheckProgress.gameProgress();
    }

    ;

    /**
     * Takes the user's inventory, plots and money and sends it to the transformProgress() method
     * in CheckProgressPresenter.
     */
    public static void boundaryOutput(HashMap<Product, Integer> inventory, ArrayList<Plot> plots, int money) {
        CheckProgressPresenter.transformProgress(inventory, plots, money);
    }

    ;
}
package usecase_interactors;

import CheckProgressUseCase.CheckProgressPresenter;
import entities.Plot;
import entities.Product;
import save_state_use_case.State;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckProgressBoundary implements UseCaseInteractorBoundary {
    /**
     * Calls the gameProgress() method in State to find information on the user's
     * inventory, plots and money.
     */
    public static void boundaryInput() {
        State.gameProgress();
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
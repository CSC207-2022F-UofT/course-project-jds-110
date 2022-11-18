package CheckProgressUseCase;

import Use_Case_Interactors.CheckProgressBoundary;
/**
 * The CheckProgressController class checks the user's command input to
 * fetch information about their farm.
 */
public class CheckProgressController {
    /**
     * getProgress() calls accesses the UseCaseBoundary interface to get information
     * about the user's inventory, plots and money.
     */
    public void getProgress(){
        // Find inventory and plots information
        CheckProgressBoundary.boundaryInput();
    }
}

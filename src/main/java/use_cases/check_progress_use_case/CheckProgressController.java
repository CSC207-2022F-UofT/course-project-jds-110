package use_cases.check_progress_use_case;

/**
 * The CheckProgressController class checks the user's command input to
 * fetch information about their farm.
 */
public class CheckProgressController {
    /**
     * getProgress() calls accesses the UseCaseBoundary interface to get information
     * about the user's inventory, plots and money.
     */
    public static String gameProgress(){
        // Find inventory and plots information
        return CheckProgress.fetchProgress();
    }
}
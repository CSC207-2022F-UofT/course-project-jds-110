package ShareUseCase;

import Entities.Plot;
import LeaderboardUseCase.Leaderboard;
import LeaderboardUseCase.LeaderboardPlace;
import Use_Case_Interactors.PlotManager;

import java.util.ArrayList;

public class Sharer {
    public static String getRanking(){
        ArrayList<LeaderboardPlace> currStandings = Leaderboard.getLeaderboard();
        LeaderboardPlace firstPlace = currStandings.get(0);
        LeaderboardPlace secondPlace = currStandings.get(1);
        LeaderboardPlace thirdPlace = currStandings.get(2);
        return "\uD83E\uDD47 " +
                firstPlace.getFarmNamesString() + " with $" + firstPlace.getAmountOfMoney() +
                "\n \uD83E\uDD48 " +
                secondPlace.getFarmNamesString() + " with $" + firstPlace.getAmountOfMoney() +
                "\uD83E\uDD49 " +
                thirdPlace.getFarmNamesString() + "with $" + thirdPlace.getAmountOfMoney();
    }

    public static StringBuilder getFarmAppearance(){
        ArrayList<Plot> plots = PlotManager.getMyPlots();
        StringBuilder totalFarmString = new StringBuilder();
        for (Plot p : plots) {
            StringBuilder currPlotInfo = p.getProductEmoji();
            totalFarmString.append(currPlotInfo);
        }
        return totalFarmString;
    }
}

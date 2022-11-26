package leaderboard_usecase;

import Use_Case_Interactors.InventoryManager;

import java.util.ArrayList;

public class Leaderboard {
    public static ArrayList<LeaderboardPlace> standings = new ArrayList<LeaderboardPlace>();
//    ex. [a, b] where a and b are classes of LeaderBoardPlace
//    a has money of 200 and name of 'MyFarm' and b has money of 100 and name of 'YourFarm'

    public static ArrayList<LeaderboardPlace> getLeaderboard(){
        int currMoney = InventoryManager.getMyInventoryMoney();
        String name = InventoryManager.getFarmname();
        Leaderboard.updateLeaderboard(currMoney, name);
        return standings;
    }

    public static void updateLeaderboard(int loadedMoney, String loadedFarmName){
        // assuming that load farm will then call this with the farm's money
        LeaderboardPlace inputPlace = new LeaderboardPlace(loadedMoney, loadedFarmName);

        // remove duplicates if necessary
        for (int i = 0; i < standings.size(); i++){
            LeaderboardPlace currFarm = standings.get(i);
            ArrayList<String> currFarmsNames = currFarm.getFarmNames();

            if (currFarmsNames.contains(loadedFarmName)) {
                currFarmsNames.remove(loadedFarmName);
                if (currFarmsNames.size() == 0) {
                    standings.remove(i);
                }
                break;
            }
        }

        // add the input place to standings if there's already stuff in it
        for (int i = 0; i < standings.size(); i++){
            LeaderboardPlace currFarm = standings.get(i);
            if (loadedMoney == currFarm.getAmountOfMoney()) {
                // add it to a farmnames associated with a leaderboardplace if one with the same amount of money exists
                currFarm.updateFarmNames(loadedFarmName);
                break;
            } else if (loadedMoney > currFarm.getAmountOfMoney()) {
                // insert loadedMoney here so the rest get pushed back
                standings.add(i, inputPlace);
                break;
            } else if (i == standings.size() - 1) {
                standings.add(inputPlace);
                break;
            }

        }
        // add input place if there isn't anything in it yet
        if (standings.size() == 0) {
            standings.add(inputPlace);
        }
    }

    public static void resetLeaderboard() {
        standings = new ArrayList<LeaderboardPlace>();
    }
}
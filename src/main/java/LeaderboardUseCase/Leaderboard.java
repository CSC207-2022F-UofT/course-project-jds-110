package LeaderboardUseCase;

import Use_Case_Interactors.InventoryManager;
import SaveStateUseCase.State;

import java.util.ArrayList;

public class Leaderboard {
    public static ArrayList<LeaderboardPlace> standings;
//    ex. [a, b] where a and b are classes of LeaderBoardPlace
//    a has money of 200 and name of 'MyFarm' and b has money of 100 and name of 'YourFarm'

    /*
    public static ArrayList<LeaderboardPlace> getLeaderboard(){
        int currMoney = InventoryManager.getMyInventoryMoney();
        String name = State.getName(); // **make sure call to state is correct
        updateLeaderboard(currMoney, name);
        return standings;
    }

     */

    public static void updateLeaderboard(int loadedMoney, String loadedFarmName){
        // assuming that load farm will then call this with the farm's money
        for (int i = 0; i < standings.size(); i++){
            LeaderboardPlace currFarm = standings.get(i);
            if (loadedMoney == currFarm.getAmountOfMoney()) {
                currFarm.updateFarmNames(loadedFarmName);
            }
            if (loadedMoney > currFarm.getAmountOfMoney()) {
                // insert loadedMoney here so the rest get pushed back
                LeaderboardPlace newPlace = new LeaderboardPlace(loadedMoney, loadedFarmName);
                standings.add(i, newPlace);
            }
            ArrayList<String> currFarmsNames = currFarm.getFarmNames();
            if (currFarmsNames.contains(loadedFarmName)) {
                standings.remove(i);
            }
        }
    }

}
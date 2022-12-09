package use_cases.leaderboard_use_case;

import use_case_interactors.InventoryManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the actual leaderboard.
 */
public class Leaderboard {
    /**
     * Standings is an ArrayList of LeaderboardPlaces.
     * Example standings: [a, b] where a and b are classes of LeaderBoardPlace
     * and a has money of 200 and name of 'MyFarm' and b has money of 100 and name of 'YourFarm'
     */
    public static ArrayList<LeaderboardPlace> standings = new ArrayList<>();

    /**
     * @return This returns the current standings
     * Note that this call also calls updateLeaderboard so the player's money, and FarmName in the leaderboard
     * will be the same as it is in the game when they're calling it.
     */
    public static ArrayList<LeaderboardPlace> getLeaderboard() throws IOException {
        int currMoney = InventoryManager.getMyInventoryMoney();
        String name = InventoryManager.getName();
        Leaderboard.updateLeaderboard(currMoney, name);

        String path = System.getProperty("user.dir") + "/src/main/farms/Farms.txt";
        Path of = Path.of(path);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(of, StandardCharsets.UTF_8));

        ArrayList<Integer> money = new ArrayList<>();
        ArrayList<String> farmNames = new ArrayList<>();

        for (int i = 0; i < fileContent.size(); i++) {
            if (i % 2 == 0) {
                farmNames.add(fileContent.get(i));
            } else {
                money.add(Integer.valueOf(fileContent.get(i)));
            }
        }

        for (int i = 0; i < money.size(); i++) {
            updateLeaderboard(money.get(i), farmNames.get(i));
        }


        return standings;
    }

    /**
     * This function adds the given farm's information to the Leaderboard.
     * @param inputMoney This is the amount of money the farm has.
     * @param inputFarmName This is the name of the farm.
     */
    public static void updateLeaderboard(int inputMoney, String inputFarmName){
        // assuming that load farm will then call this with the farm's money
        LeaderboardPlace inputPlace = new LeaderboardPlace(inputMoney, inputFarmName);

        // remove duplicates if necessary
        for (int i = 0; i < standings.size(); i++){
            LeaderboardPlace currFarm = standings.get(i);
            ArrayList<String> currFarmsNames = currFarm.getFarmNames();

            if (currFarmsNames.contains(inputFarmName)) {
                currFarmsNames.remove(inputFarmName);
                if (currFarmsNames.size() == 0) {
                    standings.remove(i);
                }
                break;
            }
        }

        // add the input place to standings if there's already stuff in it
        for (int i = 0; i < standings.size(); i++){
            LeaderboardPlace currFarm = standings.get(i);
            if (inputMoney == currFarm.getAmountOfMoney()) {
                // add it to a farmnames associated with a leaderboardplace if one with the same amount of money exists
                currFarm.updateFarmNames(inputFarmName);
                break;
            } else if (inputMoney > currFarm.getAmountOfMoney()) {
                // insert inputMoney here so the rest get pushed back
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
        standings = new ArrayList<>();
    }
}
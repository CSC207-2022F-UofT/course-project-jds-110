package LeaderboardUseCase;

import java.util.ArrayList;

/**
 * This is the dataclass associated with Leaderboard.
 * In other words, this class contains the names of the farms with each amount of money.
 */
public class LeaderboardPlace {
    private final int AmountOfMoney;
    private final ArrayList<String> farmNames;

    /**
     * This is the intializer for LeaderboardPlace.
     * @param money This should be the amount of money the farm has
     * @param farmName This should be the name of the relevant farm
     */
    public LeaderboardPlace(int money, String farmName) {
        this.AmountOfMoney = money;
        this.farmNames = new ArrayList<>();
        this.farmNames.add(farmName);
    }

    /**
     * This is just a simple getter.
     * @return This returns the amount of money associated with a LeaderboardPlace
     */
    public int getAmountOfMoney() {
        return AmountOfMoney;
    }

    public ArrayList<String> getFarmNames() {
        return farmNames;
    }

    /**
     * This is similar to a simple getter however it formats the String to be more human-friendly.
     * Ex. "Farm1" or "Farm1, and Farm2"
     * @return The names of the farms with the amount of money associated with the LeaderboardPlace.
     */
    public String getFarmNamesString() {
        StringBuilder allNames = new StringBuilder(farmNames.get(0));
        int len = farmNames.size();
        for (int i = 1; i < len - 1; i++) {
            allNames.append(", ").append(farmNames.get(i));
        }
        if (len > 1) {
            allNames.append(", and ");
            allNames.append(farmNames.get(len - 1));
        }

        return allNames.toString();
    }

    public void updateFarmNames(String newName) {
        this.farmNames.add(newName);
    }
}
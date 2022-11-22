package leaderboard_usecase;

import java.util.ArrayList;

public class LeaderboardPlace {
    private final int AmountOfMoney;
    private ArrayList<String> farmNames;

    public LeaderboardPlace(int money, String farmName) {
        this.AmountOfMoney = money;
        this.farmNames = new ArrayList<String>();
        this.farmNames.add(farmName);
    }

    public int getAmountOfMoney() {
        return AmountOfMoney;
    }

    public ArrayList<String> getFarmNames() {
        return farmNames;
    }

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
package Leaderboard;

public class LeaderboardPlace {
    private int AmountOfMoney;
    private String farmNames;

    public LeaderboardPlace(int money, String farmName) {
        this.AmountOfMoney = money;
        this.farmNames = farmName;
    }

    public int getAmountOfMoney() {
        return AmountOfMoney;
    }

    public void updateFarmNames(String newName) {
        this.farmNames = this.farmNames + ", " + newName;
    }
}

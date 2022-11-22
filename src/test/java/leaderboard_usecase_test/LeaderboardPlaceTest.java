package leaderboard_usecase_test;

import leaderboard_usecase.LeaderboardPlace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class LeaderboardPlaceTest {

    private LeaderboardPlace lpone;
    private LeaderboardPlace lpmultiple;

    @BeforeEach
    void setUp() {
        lpone = new LeaderboardPlace(100, "Wow");
        lpmultiple = new LeaderboardPlace(100, "Wow");
        lpmultiple.updateFarmNames("Wow2");
        lpmultiple.updateFarmNames("Wow3");
    }

    @Test
    void getAmountOfMoney() {
        Assertions.assertEquals(100, lpone.getAmountOfMoney());
    }

    @Test
    void getFarmNamesOne() {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Wow");
        Assertions.assertEquals(expected, lpone.getFarmNames());
    }

    @Test
    void getFarmNamesStringOne() {
        Assertions.assertEquals("Wow", lpone.getFarmNamesString());
    }

    @Test
    void updateFarmNames() {
        LeaderboardPlace lp = new LeaderboardPlace(100, "lol");
        lp.updateFarmNames("lol2");
        ArrayList<String> expected2 = new ArrayList<String>();
        expected2.add("lol");
        expected2.add("lol2");
        Assertions.assertEquals(expected2, lp.getFarmNames());
    }

    @Test
    void getFarmNamesStringMultiple() {
        String expected3 = "Wow, Wow2, and Wow3";
        Assertions.assertEquals(expected3, lpmultiple.getFarmNamesString());
    }
}
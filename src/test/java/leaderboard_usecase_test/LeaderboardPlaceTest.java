package leaderboard_usecase_test;

import LeaderboardUseCase.LeaderboardPlace;
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

    /**
     * Test if the leaderboard place is associated with the right amount of money
     */
    @Test
    void getAmountOfMoney() {
        Assertions.assertEquals(100, lpone.getAmountOfMoney());
    }

    /**
     * Test if getting just one farm name with getFarmNames works
     */
    @Test
    void getFarmNamesOne() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Wow");
        Assertions.assertEquals(expected, lpone.getFarmNames());
    }

    /**
     * Test if getting just one farm name with getFarmNamesString works
     */
    @Test
    void getFarmNamesStringOne() {
        Assertions.assertEquals("Wow", lpone.getFarmNamesString());
    }

    /**
     * Test if the leaderboard places can properly add a new farm to the
     * Arraylist of FarmNames associated with an amount of money
     */
    @Test
    void updateFarmNames() {
        LeaderboardPlace lp = new LeaderboardPlace(100, "lol");
        lp.updateFarmNames("lol2");
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("lol");
        expected2.add("lol2");
        Assertions.assertEquals(expected2, lp.getFarmNames());
    }

    /**
     * Test if that FarmNamesString returns the multiple farms
     * corresponding to a leaderboard placein a nice fashion (i.e. with commas and 'and')
     */
    @Test
    void getFarmNamesStringMultiple() {
        String expected3 = "Wow, Wow2, and Wow3";
        Assertions.assertEquals(expected3, lpmultiple.getFarmNamesString());
    }
}
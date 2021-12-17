package baseball.model;

import baseball.model.enums.ScoreCode;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.model.enums.ScoreCode.*;

public class ComputerNumber {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String EXIT_CODE = "2";

    private List<Integer> digits;

    public ComputerNumber() {
    }

    public void setRandomNumber() {
        Set<Integer> digitSet = new HashSet<>();

        while (digitSet.size() < CNT_NUMBER) {
            digitSet.add(getRandomNumber());
        }

        digits = new ArrayList<>(digitSet);
    }

    public boolean isReadyToExit(String input) {
        return EXIT_CODE.equals(input);
    }

    public ScoreCode getScoreStatus(int num, int index) {
        for (int i = 0; i < CNT_NUMBER; i++) {
            Integer digit = digits.get(i);
            if (digit == num && i == index) {
                return STRIKE;
            }
            if (digit == num) {
                return BALL;
            }
        }
        return NOTHING;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

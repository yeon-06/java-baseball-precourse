package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String EXIT_CODE = "2";
    private static final int STRIKE_CODE= 2;
    private static final int BALL_CODE= 1;


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

    public int isStrikeOrBall(int num, int index) {
        for(int i=0;i<CNT_NUMBER;i++) {
            Integer digit = digits.get(i);
            if(digit == num && i == index) {
                return STRIKE_CODE;
            }
            if(digit == num) {
                return BALL_CODE;
            }
        }
        return -1;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

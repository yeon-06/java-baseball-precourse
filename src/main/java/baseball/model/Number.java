package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Number {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int[] digits;

    public Number() {
    }

    public int[] getDigits() {
        return this.digits;
    }

    public void setRandomNumber() {
        Set<Integer> digitSet = new HashSet<>();

        while (digitSet.size() < CNT_NUMBER) {
            digitSet.add(getRandomNumber());
        }

        this.digits = convertIntegerSetToIntArray(digitSet);
    }

    public void setDigits(String input) {
        this.digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int[] convertIntegerSetToIntArray(Set<Integer> set) {
        return set.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}

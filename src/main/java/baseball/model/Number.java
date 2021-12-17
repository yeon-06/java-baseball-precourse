package baseball.model;

import java.util.Arrays;

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

    public void setDigits(String input) {
        this.digits = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

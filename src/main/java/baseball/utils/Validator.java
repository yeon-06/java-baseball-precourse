package baseball.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_NUMBER_REGAX = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]*$";
    private static final String EXIT_CODE_REGAX = "[1-2]";

    public Validator() {
    }

    public boolean isValidString(String input) {
        return isRightLength(input) && isMinToMax(input) && isNotDuplicate(input);
    }

    public boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile(EXIT_CODE_REGAX);
        return pattern.matcher(input).matches();
    }

    private boolean isRightLength(String input) {
        return input.length() == CNT_NUMBER;
    }

    private boolean isMinToMax(String input) {
        Pattern numberPattern = Pattern.compile(INPUT_NUMBER_REGAX);
        return numberPattern.matcher(input).matches();
    }

    private boolean isNotDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (char s : input.toCharArray()) {
            set.add(s);
        }
        return input.length() == set.size();
    }
}

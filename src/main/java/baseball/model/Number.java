package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Number {
	private static final int CNT_NUMBER = 3;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final String REGAX = "^["+MIN_NUMBER+"-"+MAX_NUMBER+"]*$";
	
	private int[] digits;
	
	public Number() {}
	
	public int[] getDigits() {
		return this.digits;
	}
	
	public void setRandomNumber() {
		Set<Integer> digitSet = new HashSet<>();

		while(digitSet.size() < CNT_NUMBER) {
			digitSet.add(getRandomNumber());
		}
		
		this.digits = convertIntegerSetToIntArray(digitSet);
	}
	
	public void inputAnswer(String str) {
		setDigits(str);
	}
	
	private int[] convertIntegerSetToIntArray (Set<Integer> set) {
		return set.stream()
					.mapToInt(Integer::intValue)
					.toArray();
	}
	
	private int getRandomNumber() {
		return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
	}
	
	public void setDigits(String input) {
		if(!isValidString(input)) {
			throw new IllegalArgumentException();
		}
		this.digits = Arrays.stream(input.split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
	}
	
	private boolean isValidString(String str) {
		return isRightLength(str) && isMinToMax(str) && isNotDuplicate(str);
	}
	
	private boolean isRightLength(String input) {
		return input.length() == CNT_NUMBER;
	}
	
	private boolean isMinToMax(String input) {
		Pattern numberPattern = Pattern.compile(REGAX);
		return numberPattern.matcher(input).matches();
	}

	private boolean isNotDuplicate(String input) {
		Set<Character> set = new HashSet<>();
		for(char s: input.toCharArray()) {
			set.add(s);
		}
		return input.length() == set.size();
	}
}

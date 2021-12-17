package baseball.view;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String EXIT_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Validator validator = new Validator();

    public InputView() {

    }

    public String inputAnswer() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();
        if(!validator.isValidString(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String inputExit() {
        System.out.println(EXIT_SENTENCE);
        String input = Console.readLine();
        if(!isRightAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean isRightAnswer(String input) {
        Pattern pattern = Pattern.compile("[1-2]");
        return pattern.matcher(input).matches();
    }
}
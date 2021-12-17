package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.enums.ScoreCode;
import baseball.view.InputView;

import static baseball.model.enums.ScoreCode.*;

public class GameSystem {
    private static final int CNT_NUMBER = 3;
    private static final String ALL_STRIKE_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final InputView inputView = new InputView();

    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public GameSystem() {
    }

    public void startGame() {
        PlayerNumber playerNumber = new PlayerNumber();
        ComputerNumber computerNumber = new ComputerNumber();

        computerNumber.setRandomNumber();

        while (!exit) {
            String input = inputView.inputAnswer();
            playerNumber.setDigits(input);

            resetScore();
            calculateScore(computerNumber, playerNumber);
            printResult();

            if (strike == CNT_NUMBER) {
                readyToExit(computerNumber);
            }
        }
    }

    private void calculateScore(ComputerNumber computer, PlayerNumber player) {
        for (int i = 0; i < CNT_NUMBER; i++) {
            ScoreCode score = computer.getScoreStatus(player.getDigit(i), i);
            if (score == BALL) {
                ball++;
                continue;
            }
            if (score == STRIKE) {
                strike++;
            }
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void readyToExit(ComputerNumber computerNumber) {
        String input = inputView.inputExit();
        if (computerNumber.isReadyToExit(input)) {
            exit = true;
        } else {
            computerNumber.setRandomNumber();
        }
    }

    private void printResult() {
        System.out.println(this);
        if (strike == CNT_NUMBER) {
            System.out.println(ALL_STRIKE_SENTENCE);
        }
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return NOTHING.getValue();
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append(BALL.getValue()).append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE.getValue());
        }
        return sb.toString();
    }
}

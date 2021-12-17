package baseball;

import baseball.controller.GameSystem;

public class Application {
    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        game.startGame();
    }
}

package baseball.model.enums;

public enum ScoreCode {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String value;

    ScoreCode(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

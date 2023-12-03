package pairmatching.enumeration;

public enum MenuType {
    EXIT("Q"),
    PAIR_MATCHING("1"),
    GET_PAIR("2"),
    RESET_PAIR("3");

    private String mode;

    MenuType(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}

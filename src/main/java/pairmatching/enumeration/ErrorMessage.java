package pairmatching.enumeration;

public enum ErrorMessage {
    INVALID_MISSION_NAME("[ERROR] 잘못된 미션 이름입니다."),
    INVALID_LEVEL_NAME("[ERROR] 잘못된 레벨 이름입니다."),
    INVALID_COURSE_NAME("[ERROR] 잘못된 과정 이름입니다.");


    private String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package pairmatching.domain;

import pairmatching.enumeration.ErrorMessage;

public enum Mission {
    RACING("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    IMPROVEMENT("성능개선"),
    RELEASE("배포");

    private String name;
    Mission(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static public Mission getByName(String name) {
        for(Mission mission : Mission.values()) {
            if(mission.name.equals(name)) {
                return mission;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_MISSION_NAME.getMessage());
    }
}

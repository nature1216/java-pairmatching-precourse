package pairmatching.domain;

import pairmatching.enumeration.ErrorMessage;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    public String getName() {
        return name;
    }

    Level(String name) {
        this.name = name;
    }

    static public Level getByName(String name) {
        for(Level level : Level.values()) {
            if(level.name.equals(name)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LEVEL_NAME.getMessage());
    }
}

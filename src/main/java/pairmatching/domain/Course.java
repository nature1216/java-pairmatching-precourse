package pairmatching.domain;

import pairmatching.enumeration.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static public Course getByName(String name) {
        for(Course course : Course.values()) {
            if(course.name.equals(name)) {
                return course;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_COURSE_NAME.getMessage());
    }
}

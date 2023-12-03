package pairmatching.domain;

import java.awt.datatransfer.FlavorEvent;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Crew {
    private Course course;
    private String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

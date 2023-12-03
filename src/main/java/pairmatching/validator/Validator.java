package pairmatching.validator;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class Validator {
    static public void validateInput(String input) {
        String[] infos = input.split(",");
        Course course = Course.getByName(infos[0]);
        Level level = Level.getByName(infos[1]);
        Mission mission = Mission.getByName(infos[2]);
    }
}

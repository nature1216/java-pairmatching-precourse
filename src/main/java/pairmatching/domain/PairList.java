package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairList {
    private Level level;
    private Course course;
    private Mission mission;
    private List<Pair> pairs;

    public PairList(Level level, Course course, Mission mission) {
        this.level = level;
        this.course = course;
        this.mission = mission;
        pairs = new ArrayList<>();
    }

    public void update(Pair pair) {
        pairs.add(pair);
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public Level getLevel() {
        return level;
    }

    public boolean exist(Level level, Course course, Mission mission) {
        System.out.println(this.level.getName() + level.getName() + "비교");
        return level == this.level && course == this.course && mission == this.mission;
    }

    public boolean compareList(PairList pairList) {
        if(level != pairList.getLevel()) {
            return true;
        }
        for(Pair pair1 : pairs) {
            for(Pair pair2 : pairList.getPairs()) {
                if(pair1.equals(pair2)) {
                    return false;
                }
            }
        }
        return true;
    }
}

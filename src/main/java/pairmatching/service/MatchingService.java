package pairmatching.service;

import pairmatching.domain.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    public List<String> getCrewNames(Course course) {
        List<String> names = new ArrayList<>();
        String path = "/Users/jayeonkim/Anne/Dev/woowacourse/pre-course/java-pairmatching-precourse/src/main/resources/frontend-crew.md";

        if(course == Course.BACKEND) {
            path = "/Users/jayeonkim/Anne/Dev/woowacourse/pre-course/java-pairmatching-precourse/src/main/resources/backend-crew.md";
        }

        try {
            names = Files.lines(Paths.get(path))
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return names;
    }

    public PairList pairMatching(String input) {
        String[] infos = input.split(",");
        Course course = Course.getByName(infos[0]);
        Level level = Level.getByName(infos[1]);
        Mission mission = Mission.getByName(infos[2]);

        PairList pairs = new PairList(level, course, mission);
        List<String> names = getCrewNames(course);
        names = Randoms.shuffle(names);

        makePair(pairs, course, names);

        return pairs;
    }

    private void makePair(PairList pairs, Course course, List<String> names) {
        for(int i=0;i<names.size();i+=2) {
            Crew crew1 = new Crew(course, names.get(i));
            Crew crew2 = new Crew(course, names.get(i + 1));
            Pair pair = new Pair(crew1, crew2);
            if(names.size() % 2 != 0 && i == names.size() - 3) {
                Crew crew3 = new Crew(course, names.get(i + 2));
                pair = new Pair(crew1, crew2, crew3);
                pairs.update(pair);
                break;
            }
            pairs.update(pair);
        }
    }

    public PairList getPair(List<PairList> pairLists, String input) {
        String[] infos = input.split(",");
        Course course = Course.getByName(infos[0]);
        Level level = Level.getByName(infos[1]);
        Mission mission = Mission.getByName(infos[2]);

        for(PairList pairList : pairLists) {
            if(pairList.exist(level, course, mission)) {
                return pairList;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isExist(String input, List<PairList> pairLists) {
        String[] infos = input.split(",");
        Course course = Course.getByName(infos[0]);
        Level level = Level.getByName(infos[1]);
        Mission mission = Mission.getByName(infos[2]);

        for(PairList pairList : pairLists) {
            if(pairList.exist(level, course, mission)) {
                return true;
            }
        }
        return false;
    }

    public int getPairListIndex(String input, List<PairList> pairLists) {
        String[] infos = input.split(",");
        Course course = Course.getByName(infos[0]);
        Level level = Level.getByName(infos[1]);
        Mission mission = Mission.getByName(infos[2]);

        for(PairList pairList : pairLists) {
            if(pairList.exist(level, course, mission)) {
                return pairLists.indexOf(pairList);
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean canMakePair(List<PairList> pairLists, PairList pairList) {
        for(PairList compPair : pairLists) {
            if(!compPair.compareList(pairList)) {
                return false;
            }
        }
        return true;
    }
}

package pairmatching.domain;

import java.util.*;

public class Pair {
    private List<Crew> pair;

    public Pair(Crew ... crews) {
        if(crews.length > 3) {
            throw new IllegalArgumentException();
        }
        pair = new ArrayList<>(Arrays.asList(crews));
    }

    public List<Crew> getPair() {
        return pair;
    }

    public void printCrewNames() {
        List<String> names = new ArrayList<>();
        for(Crew crew : pair) {
            names.add(crew.getName());
        }
        System.out.println(String.join(" : ", names));
    }

    public boolean equals(Pair pair) {
        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();
        for(Crew crew : this.pair) {
            names1.add(crew.getName());
        }
        for(Crew crew : pair.getPair()) {
            names2.add(crew.getName());
        }
        Set<String> set = new HashSet<>(names1);
        long count = names2.stream().filter(set::contains).count();
        if(count >= 2) {
            return true;
        }
        return false;
    }
}

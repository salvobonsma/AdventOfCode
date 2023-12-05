package dev.ampersanded.y2023.d5;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Tri;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        String[] sections = input.split("\n\n");

        // Uses less heap if I calculate the seed and didn't put it in an array.
        ArrayList<Long> seeds = new ArrayList<>();
        for (String seed : sections[0].split(": ")[1].split(" ")) {
            seeds.add(Long.parseLong(seed));
        }

        ArrayList<ArrayList<Tri<Long, Long, Long>>> maps = new ArrayList<>();
        for (int i = 1; i < sections.length; i++) {
            maps.add(textToMap(sections[i]));
        }

        ArrayList<Long> locations = new ArrayList<>();
        for (long seed : seeds) {
            for (ArrayList<Tri<Long, Long, Long>> map : maps) {
                seed = destinationToSource(seed, map);
            }

            locations.add(seed);
        }

        long lowest = locations.get(0);
        for (long location : locations) {
            if (location < lowest) {
                lowest = location;
            }
        }

        return lowest + "";
    }

    private long destinationToSource(long destination, ArrayList<Tri<Long, Long, Long>> map) {
        for (Tri<Long, Long, Long> convertor : map) {
            if (destination >= convertor.getSecond() && destination < convertor.getSecond() + convertor.getThird()) {
                return destination - convertor.getSecond() + convertor.getFirst();
            }
        }

        return destination;
    }

    private ArrayList<Tri<Long, Long, Long>> textToMap(String input) {
        ArrayList<Tri<Long, Long, Long>> output = new ArrayList<>();

        for (String line : input.split(":\n")[1].split("\n")) {
            String[] lineSplit = line.split(" ");

            output.add(Tri.of(
                    Long.parseLong(lineSplit[0]),
                    Long.parseLong(lineSplit[1]),
                    Long.parseLong(lineSplit[2]))
            );
        }

        return output;
    }
}

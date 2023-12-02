package dev.ampersanded.y2023.d1;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;

import java.util.ArrayList;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] lines = input.split("\n");

        int total = 0;

        for (String line : lines) {
            // Should be a HashMap
            ArrayList<Pair<String, Integer>> numberLocation = new ArrayList<>();

            for (int i = 0; i < line.length(); i++) {
                if (isNum(line.split("")[i])) {
                    numberLocation.add(Pair.of(line.split("")[i], i));
                }
            }

            // Better ways to do this
            if (line.contains("one")) { numberLocation.add(Pair.of("1", line.indexOf("one"))); }
            if (line.contains("two")) { numberLocation.add(Pair.of("2", line.indexOf("two"))); }
            if (line.contains("three")) { numberLocation.add(Pair.of("3", line.indexOf("three"))); }
            if (line.contains("four")) { numberLocation.add(Pair.of("4", line.indexOf("four"))); }
            if (line.contains("five")) { numberLocation.add(Pair.of("5", line.indexOf("five"))); }
            if (line.contains("six")) { numberLocation.add(Pair.of("6", line.indexOf("six"))); }
            if (line.contains("seven")) { numberLocation.add(Pair.of("7", line.indexOf("seven"))); }
            if (line.contains("eight")) { numberLocation.add(Pair.of("8", line.indexOf("eight"))); }
            if (line.contains("nine")) { numberLocation.add(Pair.of("9", line.indexOf("nine"))); }
            if (line.contains("one")) { numberLocation.add(Pair.of("1", line.lastIndexOf("one"))); }
            if (line.contains("two")) { numberLocation.add(Pair.of("2", line.lastIndexOf("two"))); }
            if (line.contains("three")) { numberLocation.add(Pair.of("3", line.lastIndexOf("three"))); }
            if (line.contains("four")) { numberLocation.add(Pair.of("4", line.lastIndexOf("four"))); }
            if (line.contains("five")) { numberLocation.add(Pair.of("5", line.lastIndexOf("five"))); }
            if (line.contains("six")) { numberLocation.add(Pair.of("6", line.lastIndexOf("six"))); }
            if (line.contains("seven")) { numberLocation.add(Pair.of("7", line.lastIndexOf("seven"))); }
            if (line.contains("eight")) { numberLocation.add(Pair.of("8", line.lastIndexOf("eight"))); }
            if (line.contains("nine")) { numberLocation.add(Pair.of("9", line.lastIndexOf("nine"))); }

            if (line.contains("one")) {
                numberLocation.add(Pair.of("1", line.lastIndexOf("nine")));
            }
            if (line.contains("two")) {
                numberLocation.add(Pair.of("2", line.lastIndexOf("nine")));
            }
            if (line.contains("three")) {
                numberLocation.add(Pair.of("3", line.lastIndexOf("nine")));
            }
            if (line.contains("four")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }
            if (line.contains("five")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }
            if (line.contains("six")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }
            if (line.contains("seven")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }
            if (line.contains("eight")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }
            if (line.contains("nine")) {
                numberLocation.add(Pair.of("9", line.lastIndexOf("nine")));
            }

            Pair<String, Integer> lowest = numberLocation.get(0);
            Pair<String, Integer> highest = numberLocation.get(0);

            for (Pair<String, Integer> stringIntegerPair : numberLocation) {
                if (lowest.getSecond() > stringIntegerPair.getSecond()) {
                    lowest = stringIntegerPair;
                }
                if (highest.getSecond() < stringIntegerPair.getSecond()) {
                    highest = stringIntegerPair;
                }
            }

            total += Integer.parseInt(lowest.getFirst() + highest.getFirst());
        }

        return total + "";
    }

    private boolean isNum(String s) {
        // Running a try statement on every character is inefficient
        try {
            int a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

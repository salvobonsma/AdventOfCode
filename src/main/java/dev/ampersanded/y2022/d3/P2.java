package dev.ampersanded.y2022.d3;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        List<String> backpacks = Arrays.stream(input.split("\n")).toList();
        ArrayList<ArrayList<String>> groups = new ArrayList<>();


        for (int i = 0; i < backpacks.size(); i++) {
            if (i % 3 == 0) {
                ArrayList<String> group = new ArrayList<>();
                group.add(backpacks.get(i));

                groups.add(i / 3, group);
            } else {
                ArrayList<String> group = groups.get(i / 3);
                group.add(backpacks.get(i));

                groups.set(i / 3, group);
            }
        }

        int sum = 0;

        for (ArrayList<String> group : groups) {
            sum += getCommonItemPriority(group);
        }

        return sum + "";
    }

    private int getCommonItemPriority(ArrayList<String> group) {
        ArrayList<Character> commonChars = new ArrayList<>();

        for (char item1 : group.get(0).toCharArray()) {
            for (char item2 : group.get(1).toCharArray()) {
                if (item1 == item2) {
                    commonChars.add(item1);
                }
            }
        }

        for (char item1 : group.get(2).toCharArray()) {
            for (char item2 : commonChars) {
                if (item1 == item2) {
                    return priorityFromItem(String.valueOf(item1));
                }
            }
        }

        return 0;
    }

    private int priorityFromItem(String input) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(input.toLowerCase())) {
                if (Character.isUpperCase(input.toCharArray()[0])) {
                    return i + 27;
                }
                return i + 1;
            }
        }

        return 0;
    }
}

package dev.ampersanded.y2023.d9;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;
import java.util.Optional;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;
        for (String line : input.split("\n")) {
            total += extrapolate(getDifferences(line)).get(0).get(0);
        }

        return total + "";
    }

    private ArrayList<ArrayList<Integer>> extrapolate(ArrayList<ArrayList<Integer>> input) {
        for (int i = input.size() - 1; i >= 0; i--) {
            ArrayList<Integer> level = input.get(i);
            int first = level.get(0);

            if (i == input.size() - 1) {
                level.add(0, 0);
                continue;
            }

            ArrayList<Integer> preLevel = input.get(i + 1);
            int preFirst = preLevel.get(0);

            level.add(0, first - preFirst);
        }

        return input;
    }

    private ArrayList<ArrayList<Integer>> getDifferences(String line) {
        ArrayList<ArrayList<Integer>> differences = new ArrayList<>();

        ArrayList<Integer> lastLine = new ArrayList<>();
        for (String num : line.split(" ")) {
            lastLine.add(Integer.parseInt(num));
        }
        differences.add(lastLine);

        while (!listAllZero(lastLine)) {
            ArrayList<Integer> newLastLine = new ArrayList<>();
            for (int i = 1; i < lastLine.size(); i++) {
                newLastLine.add(lastLine.get(i) - lastLine.get(i - 1));
            }

            if (newLastLine.equals(new ArrayList<>())) {
                break;
            }

            lastLine = newLastLine;
            differences.add(lastLine);
        }

        return differences;
    }

    private boolean listAllZero(ArrayList<Integer> input) {
        return input.stream().reduce(Integer::sum).equals(Optional.of(0));
    }
}

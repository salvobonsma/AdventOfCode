package dev.ampersanded.y2015.d5;

import dev.ampersanded.lib.AdventChallenge;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;
        String[] lines = input.split("\n");

        for (String line : lines) {
            if (hasRepeatingPair(line) && hasSeperatedPair(line)) {
                total++;
            }
        }

        return total + "";
    }

    private boolean hasRepeatingPair(String line) {
        for (int i = 0; i < line.length() - 1; i++) {
            String pair = line.substring(i, i + 2);
            String rest = line.substring(i + 2);
            if (rest.contains(pair)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSeperatedPair(String line) {
        for (int i = 0; i < line.length() - 2; i++) {
            if (line.charAt(i) == line.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }
}
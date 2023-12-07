package dev.ampersanded.y2023.d6;

import dev.ampersanded.lib.AdventChallenge;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] lines = input.split("\n");

        long duration = parseLine(lines[0]);
        long record = parseLine(lines[1]);

        int total = 0;
        for (long i = 0; i <= duration; i++) {
            if ((duration - i) * i > record) {
                total++;
            }
        }

        return total + "";
    }

    private Long parseLine(String line) {
        // Added parser after submission
        long output;
        StringBuilder durationString = new StringBuilder();
        for (String number : line.split(":")[1].split(" ")) {
            durationString.append(number);
        }
        output = Long.parseLong(durationString.toString());

        return output;
    }
}

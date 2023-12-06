package dev.ampersanded.y2023.d6;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        long total = 1;
        String[] lines = input.split("\n");
        ArrayList<Long> durations = parseLine(lines[0]);
        ArrayList<Long> records = parseLine(lines[1]);

        for (int i = 0; i < durations.size(); i++) {
            total *= howManyCanBeat(durations.get(i), records.get(i));
        }

        return total + "";
    }

    private long howManyCanBeat(long duration, long record) {
        long total = 0;
        for (long i = 0; i <= duration; i++) {
            if ((duration - i) * i > record) {
                total += 1;
            }
        }

        return total;
    }

    private ArrayList<Long> parseLine(String line) {
        // Added parser after submission
        ArrayList<Long> output = new ArrayList<>();
        for (String number : line.split(":")[1].split(" ")) {
            if (number.isEmpty()) continue;
            output.add(Long.parseLong(number));
        }

        return output;
    }
}

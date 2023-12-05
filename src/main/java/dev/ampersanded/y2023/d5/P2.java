package dev.ampersanded.y2023.d5;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Tri;

import java.util.ArrayList;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] sections = input.split("\n\n");
        System.out.println("May take awhile to generate...");

        long lowest = -1;

        ArrayList<ArrayList<Tri<Long, Long, Long>>> maps = new ArrayList<>();
        for (int i = 1; i < sections.length; i++) {
            maps.add(textToMap(sections[i]));
        }

        // Extreme brute force, took my M2 mac eight minutes to process.
        String[] seedsSplit = sections[0].split(": ")[1].split(" ");
        for (int i = 0; i < seedsSplit.length; i += 2) {
            System.out.printf("Range %d/%d%n", i / 2 + 1, seedsSplit.length / 2);
            long a = Long.parseLong(seedsSplit[i]);
            long b = Long.parseLong(seedsSplit[i + 1]);
            for (long j = a; j < a + b; j++) {
                long seed = j;

                for (ArrayList<Tri<Long, Long, Long>> map : maps) {
                    seed = destinationToSource(seed, map);
                }

                if (lowest == -1) {
                    lowest = seed;
                } else {
                    lowest = Math.min(lowest, seed);
                }
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

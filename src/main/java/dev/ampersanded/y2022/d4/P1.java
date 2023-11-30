package dev.ampersanded.y2022.d4;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;
import dev.ampersanded.lib.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        for (String rangePairs : input.split("\n")) {
            ArrayList<Integer> rangeA = stringArrayToIntArray(rangePairs.split(",")[0].split("-"));
            ArrayList<Integer> rangeB = stringArrayToIntArray(rangePairs.split(",")[1].split("-"));

            total += fullyContains(
                    Pair.of(rangeA.get(0), rangeA.get(1)), Pair.of(rangeB.get(0), rangeB.get(1))
            ) ? 1 : 0;
        }

        return total + "";
    }

    private boolean fullyContains(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return (a.getFirst() <= b.getFirst() && a.getSecond() >= b.getSecond()) ||
                (a.getFirst() >= b.getFirst() && a.getSecond() <= b.getSecond());
    }

    private ArrayList<Integer> stringArrayToIntArray(String[] input) {
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            output.add(Integer.valueOf(input[i]));
        }

        return output;
    }
}

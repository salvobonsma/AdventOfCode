package dev.ampersanded.y2022.d4;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;
import dev.ampersanded.lib.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        for (String rangePairs : input.split("\n")) {
            ArrayList<Integer> rangeA = stringArrayToIntArray(rangePairs.split(",")[0].split("-"));
            ArrayList<Integer> rangeB = stringArrayToIntArray(rangePairs.split(",")[1].split("-"));

            total += overlaps(
                    Pair.of(rangeA.get(0), rangeA.get(1)), Pair.of(rangeB.get(0), rangeB.get(1))
            ) ? 1 : 0;
        }

        return total + "";
    }

    private boolean overlaps(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        for (int i = a.getFirst(); i <= a.getSecond(); i++) {
            for (int i2 = b.getFirst(); i2 <= b.getSecond(); i2++) {
                if (i == i2) { return true;  }
            }
        }
        return false;
    }

    private ArrayList<Integer> stringArrayToIntArray(String[] input) {
        ArrayList<Integer> output = new ArrayList<>();

        for (String string : input) {
            output.add(Integer.valueOf(string));
        }

        return output;
    }
}

package dev.ampersanded.y2022.d1;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        List<String> elfSplit = Arrays.stream(input.split("\n\n")).toList();
        ArrayList<Integer> elfSum = new ArrayList<>();

        for (int i = 0; i < elfSplit.size(); i++) {
            int total = 0;

            for (String s : elfSplit.get(i).split("\n")) {
                total += Integer.parseInt(s);
            }

            elfSum.add(i, total);
        }

        return Utils.orderLargestToSmallest(elfSum).get(0) + "";
    }
}

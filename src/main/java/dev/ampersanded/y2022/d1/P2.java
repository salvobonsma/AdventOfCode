package dev.ampersanded.y2022.d1;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 extends AdventChallenge {
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

        ArrayList<Integer> elfs = Utils.orderLargestToSmallest(elfSum);

        return (elfs.get(0) + elfs.get(1) + elfs.get(2)) + "";
    }
}

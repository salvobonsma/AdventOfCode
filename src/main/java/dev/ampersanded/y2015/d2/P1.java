package dev.ampersanded.y2015.d2;

import dev.ampersanded.lib.AdventChallenge;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        for (String line : input.split("\n")) {
            String[] lineSplit = line.split("x");

            int w = Integer.parseInt(lineSplit[0]);
            int h = Integer.parseInt(lineSplit[1]);
            int l = Integer.parseInt(lineSplit[2]);

            int side1 = l * w;
            int side2 = h * w;
            int side3 = h * l;

            int smallestSide = side1;
            if (side2 < smallestSide) {
                smallestSide = side2;
            }
            if (side3 < smallestSide) {
                smallestSide = side3;
            }

            total += side1 * 2 + side2 * 2 + side3 * 2 + smallestSide;
        }

        return total + "";
    }
}

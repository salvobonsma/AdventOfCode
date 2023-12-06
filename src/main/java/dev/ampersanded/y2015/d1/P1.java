package dev.ampersanded.y2015.d1;

import dev.ampersanded.lib.AdventChallenge;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int floor = 0;

        String[] letters = input.split("");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals("(")) {
                floor += 1;
            } else {
                floor -= 1;
            }
        }

        return floor + "";
    }
}

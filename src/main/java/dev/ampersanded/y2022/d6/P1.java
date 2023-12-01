package dev.ampersanded.y2022.d6;

import dev.ampersanded.lib.AdventChallenge;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        for (int i = 0; i < input.length() - 4; i++) {
            if (isMarker(input.substring(i, i + 4))) {
                return i + 4 + "";
            }
        }

        return "No answer";
    }

    private boolean isMarker(String input) {
        int repeats = 0;

        for (char c1 : input.toCharArray()) {
            for (char c2 : input.toCharArray()) {
                if (c1 == c2) {
                    repeats += 1;
                }
            }
        }

        return repeats <= 4;
    }
}

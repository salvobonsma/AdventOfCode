package dev.ampersanded.y2022.d6;

import dev.ampersanded.lib.AdventChallenge;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        for (int i = 0; i < input.length() - 14; i++) {
            if (isMarker(input.substring(i, i + 14))) {
                return i + 14 + "";
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

        return repeats <= 14;
    }
}

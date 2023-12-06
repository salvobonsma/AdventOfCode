package dev.ampersanded.y2015.d5;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Utils;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;
        String[] lines = input.split("\n");

        for (String line : lines) {
            int vowels = 0;
            boolean hasDoubleLetter = false;
            for (int i = 0; i < line.split("").length; i++) {
                String letter = line.split("")[i];

                try {
                    if (letter.equals(line.split("")[i + 1])) {
                        hasDoubleLetter = true;
                    }
                } catch (Exception ignored) {
                }

                for (String vowel : Utils.vowels) {
                    vowels += letter.equals(vowel) ? 1 : 0;
                }
            }

            boolean containsBadStrings = line.contains("ab") || line.contains("cd") || line.contains("pq") ||
                    line.contains("xy");

            if (vowels >= 3 && hasDoubleLetter && !containsBadStrings) {
                total++;
            }
        }

        return total + "";
    }
}

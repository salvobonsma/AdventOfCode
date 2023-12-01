package dev.ampersanded.y2023.d1;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Utils;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        String[] lines = input.split("\n");

        int total = 0;

        for (String line : lines) {
            total += Integer.parseInt(removeLetters(line));
        }

        return total + "";
    }

    private String removeLetters(String string) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        for (String letter : alphabet) {
            string = string.replace(letter, "");
        }

        return string.charAt(0) + string.substring(string.length() - 1);
    }
}

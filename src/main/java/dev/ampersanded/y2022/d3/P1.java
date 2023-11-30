package dev.ampersanded.y2022.d3;

import dev.ampersanded.lib.AdventChallenge;

import java.util.Arrays;
import java.util.List;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        List<String> backpacks = Arrays.stream(input.split("\n")).toList();

        int sum = 0;

        for (String backpack : backpacks) {
            String commonItem = "";

            char[] compartment1 = backpack.substring(0, backpack.length() / 2).toCharArray();
            char[] compartment2 = backpack.substring(backpack.length() / 2).toCharArray();

            for (char c1 : compartment1) {
                for (char c2 : compartment2) {
                    if (c1 == c2) {
                        commonItem = String.valueOf(c1);
                        break;
                    }
                }
            }

            sum += priorityFromItem(commonItem);
        }

        return sum + "";
    }

    private int priorityFromItem(String input) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(input.toLowerCase())) {
                if (Character.isUpperCase(input.toCharArray()[0])) {
                    return i + 27;
                }
                return i + 1;
            }
        }

        return 0;
    }
}

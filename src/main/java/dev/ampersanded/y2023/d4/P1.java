package dev.ampersanded.y2023.d4;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        for (String line : input.split("\n")) {
            line = line.split(": ")[1];
            String[] lineSplit = line.split(" \\| ");

            ArrayList<Integer> winningNumbers = numbersToArray(lineSplit[0]);
            ArrayList<Integer> selectedNumbers = numbersToArray(lineSplit[1]);

            int totalLineWins = 0;

            for (int selectedNum : selectedNumbers) {
                for (int winningNum : winningNumbers) {
                    if (selectedNum == winningNum) {
                        totalLineWins += 1;
                    }
                }
            }

            int totalForLine = totalLineWins == 0 ? 0 : 1;
            for (int i = 0; i < totalLineWins - 1; i++) {
                totalForLine *= 2;
            }

            total += totalForLine;
        }

        return total + "";
    }

    private ArrayList<Integer> numbersToArray(String input) {
        ArrayList<Integer> output = new ArrayList<>();
        for (String num : input.split(" ")) {
            if (num.isEmpty()) {
                continue;
            }
            output.add(Integer.parseInt(num));
        }

        return output;
    }
}

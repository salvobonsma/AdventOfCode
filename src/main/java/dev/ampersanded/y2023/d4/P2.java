package dev.ampersanded.y2023.d4;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] original = input.split("\n");
        List<String> lines = new ArrayList<>(Arrays.stream(input.split("\n")).toList());

        for (int i = 0; i < lines.size(); i++) {
            for (int card : getCopies(lines.get(i))) {
                lines.add(original[card - 1]);
            }
        }

        return lines.size() + "";
    }

    private ArrayList<Integer> getCopies(String line) {
        int card = Integer.parseInt(line.split(":")[0].split(" ")[line.split(":")[0].split(" ").length - 1]);
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
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 1; i <= totalLineWins; i++) {
            output.add(card + i);
        }

        return output;
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

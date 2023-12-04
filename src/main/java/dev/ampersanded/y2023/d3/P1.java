package dev.ampersanded.y2023.d3;

import dev.ampersanded.lib.AdventChallenge;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String[] numbers = symbolsToPeriods(line).split("\\.");
            for (int j = 0; j < numbers.length; j++) {
                int indexOfNum = 0;
                for (int k = 0; k < j; k++) {
                    indexOfNum += numbers[k].length() + 1;
                }

                String number = numbers[j];

                number = removeNonNumbers(number);
                if (number.isEmpty()) {
                    continue;
                }

                total += Integer.parseInt(totalFromNum(line, number, lines, i, indexOfNum));
            }
        }

        return total + "";
    }

    private String totalFromNum(String line, String number, String[] lines, int i, int indexOfNum) {
        int length = number.length();

        //below
        if (i != lines.length - 1) {
            for (int k = indexOfNum - 1; k < indexOfNum + length + 1; k++) {
                if (isSymbolAtIndex(lines[i + 1], k)) {
                    return number;
                }
            }
        }

        //above
        if (i != 0) {
            for (int k = indexOfNum - 1; k < indexOfNum + length + 1; k++) {
                if (isSymbolAtIndex(lines[i - 1], k)) {
                    return number;
                }
            }
        }

        if (isSymbolAtIndex(line, indexOfNum + length)) {
            return number;
        }
        if (isSymbolAtIndex(line, indexOfNum - 1)) {
            return number;
        }

        return "0";
    }

    private String removeNonNumbers(String input) {
        StringBuilder output = new StringBuilder();

        for (String letter : input.split("")) {
            if (isNum(letter)) {
                output.append(letter);
            }
        }

        return output.toString();
    }

    private String symbolsToPeriods(String input) {
        StringBuilder output = new StringBuilder();

        for (String letter : input.split("")) {
            if (!isNum(letter)) {
                output.append(".");
            } else {
                output.append(letter);
            }
        }

        return output.toString();
    }

    private boolean isSymbolAtIndex(String input, int i) {
        String letter = null;
        try {
            letter = input.split("")[i];
        } catch (Exception e) {
            return false;
        }

        return !isNum(letter) && !letter.equals(".");
    }

    private boolean isNum(String s) {
        // Running a try statement on every character is inefficient
        try {
            int a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

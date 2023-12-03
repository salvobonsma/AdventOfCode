package dev.ampersanded.y2023.d3;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;

import java.util.ArrayList;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        int total = 0;

        ArrayList<NumberData> numberLocations = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> gears = new ArrayList<>();

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
                if (!number.isEmpty()) {
                    numberLocations.add(new NumberData(indexOfNum, i, number.length(), number));
                }
            }

            String[] chars = line.split("");
            for (int j = 0; j < lines.length; j++) {
                String letter = chars[j];

                if (letter.equals("*")) {
                    // i is the y
                    // j is the x

                    gears.add(Pair.of(j, i));
                }
            }
        }

        for (Pair<Integer, Integer> gear : gears) {
            ArrayList<String> gearRatios = new ArrayList<>();

            for (NumberData numberLocation : numberLocations) {
                for (int i = numberLocation.x; i < numberLocation.x + numberLocation.length; i++) {
                    if (gear.getFirst() == i + 1 && gear.getSecond() == numberLocation.y + 1) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i + 1 && gear.getSecond() == numberLocation.y) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i + 1 && gear.getSecond() == numberLocation.y - 1) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i && gear.getSecond() == numberLocation.y + 1) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i && gear.getSecond() == numberLocation.y) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i && gear.getSecond() == numberLocation.y - 1) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i - 1 && gear.getSecond() == numberLocation.y + 1) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i - 1 && gear.getSecond() == numberLocation.y) {
                        gearRatios.add(numberLocation.number);
                        break;
                    }
                    if (gear.getFirst() == i - 1 && gear.getSecond() == numberLocation.y - 1) {
                        gearRatios.add(numberLocation.number);
                    }
                }
            }

            if (gearRatios.size() == 2) {
                total += Integer.parseInt(gearRatios.get(0)) * Integer.parseInt(gearRatios.get(1));
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

        if (line.indexOf(number) != line.lastIndexOf(number)) {
            //System.out.println("noooo");
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

        if (isNum(letter) || letter.equals(".")) {
            return false;
        }

        return true;
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

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
                    // Would be better to not do this even though that this is efficient
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

    static class NumberData {
        int x;
        int y;
        int length;
        String number;

        public NumberData(int x, int y, int length, String number) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.number = number;
        }

        @Override
        public String toString() {
            return String.format("(x: %d, y: %d, number: %s)", x, y, number);
        }
    }
}

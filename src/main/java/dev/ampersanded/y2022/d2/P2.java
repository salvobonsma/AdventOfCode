package dev.ampersanded.y2022.d2;

import dev.ampersanded.lib.AdventChallenge;

import java.util.Arrays;
import java.util.List;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        List<String> matches = Arrays.stream(input.split("\n")).toList();

        int total = 0;
        for (String s : matches) {
            String opponentShape = s.split(" ")[0];
            String selfShape = s.split(" ")[1];

            total += pointsFromShape(playFromMatch(opponentShape, selfShape));
            total += pointsFromOutcome(stringToOutcome(selfShape));
        }

        return total + "";
    }

    private Outcome stringToOutcome(String s) {
        return switch (s) {
            case "X" -> Outcome.LOSS;
            case "Y" -> Outcome.DRAW;
            case "Z" -> Outcome.WIN;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    private int pointsFromOutcome(Outcome outcome) {
        return switch (outcome) {
            case LOSS -> 0;
            case DRAW -> 3;
            case WIN -> 6;
        };
    }

    private String playFromMatch(String opponent, String outcome) {
        return switch (opponent) {
            case "A" -> switch (outcome) {
                case "X" -> "Z";
                case "Y" -> "X";
                case "Z" -> "Y";
                default -> throw new IllegalStateException("Unexpected value: " + outcome);
            };
            case "B" -> switch (outcome) {
                case "X" -> "X";
                case "Y" -> "Y";
                case "Z" -> "Z";
                default -> throw new IllegalStateException("Unexpected value: " + outcome);
            };
            case "C" -> switch (outcome) {
                case "X" -> "Y";
                case "Y" -> "Z";
                case "Z" -> "X";
                default -> throw new IllegalStateException("Unexpected value: " + outcome);
            };
            default -> throw new IllegalStateException("Unexpected value: " + opponent);
        };
    }

    private int pointsFromShape(String s) {
        return switch (s) {
            case "X" -> 1;
            case "Y" -> 2;
            case "Z" -> 3;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    enum Outcome {
        LOSS,
        DRAW,
        WIN
    }
}

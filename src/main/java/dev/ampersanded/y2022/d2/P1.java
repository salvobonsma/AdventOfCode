package dev.ampersanded.y2022.d2;

import dev.ampersanded.lib.AdventChallenge;

import java.util.Arrays;
import java.util.List;

public class P1 extends AdventChallenge {
    enum Outcome {
        LOSS,
        DRAW,
        WIN
    }

    @Override
    public String solve() {
        List<String> matches = Arrays.stream(input.split("\n")).toList();

        int total = 0;
        for (String s : matches) {
            String opponentShape = s.split(" ")[0];
            String selfShape = s.split(" ")[1];

            total += pointsFromShape(selfShape);
            total += pointsFromOutcome(outcomeFromMatch(opponentShape, selfShape));
        }

        return total + "";
    }

    private int pointsFromOutcome(Outcome outcome) {
        return switch (outcome) {
            case LOSS -> 0;
            case DRAW -> 3;
            case WIN -> 6;
        };
    }

    private Outcome outcomeFromMatch(String opponent, String self) {
        return switch (opponent) {
            case "A" -> switch (self) {
                case "X" -> Outcome.DRAW;
                case "Y" -> Outcome.WIN;
                case "Z" -> Outcome.LOSS;
                default -> throw new IllegalStateException("Unexpected value: " + self);
            };
            case "B" -> switch (self) {
                case "X" -> Outcome.LOSS;
                case "Y" -> Outcome.DRAW;
                case "Z" -> Outcome.WIN;
                default -> throw new IllegalStateException("Unexpected value: " + self);
            };
            case "C" -> switch (self) {
                case "X" -> Outcome.WIN;
                case "Y" -> Outcome.LOSS;
                case "Z" -> Outcome.DRAW;
                default -> throw new IllegalStateException("Unexpected value: " + self);
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
}

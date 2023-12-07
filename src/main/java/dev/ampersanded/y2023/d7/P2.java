package dev.ampersanded.y2023.d7;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;
import dev.ampersanded.lib.Tri;

import java.util.ArrayList;
import java.util.HashMap;

public class P2 extends AdventChallenge {
    String[] cards = "J23456789TQKA".split("");

    @Override
    public String solve() {
        // hand, type, bid
        ArrayList<Tri<String, Type, Integer>> hands = new ArrayList<>();
        for (int i = 0; i < input.split("\n").length; i++) {
            String[] lineSplit = input.split("\n")[i].split(" ");
            Type type = getTypeWithJAsWildcard(lineSplit[0]);
            hands.add(Tri.of(lineSplit[0], type, Integer.parseInt(lineSplit[1])));
        }

        hands.sort((triA, triB) -> {
            int typeComparison = Integer.compare(triA.getSecond().power, triB.getSecond().power);
            return typeComparison == 0 ? compareCardPowers(triA.getFirst(), triB.getFirst()) : typeComparison;
        });

        int total = 0;
        for (int i = 0; i < hands.size(); i++) {
            total += (i + 1) * hands.get(i).getThird();
        }

        return total + "";
    }

    private int compareCardPowers(String handA, String handB) {
        for (int i = 0; i < handA.length(); i++) {
            int powerComparison = Integer.compare(
                    cardPower(handA.split("")[i]),
                    cardPower(handB.split("")[i])
            );
            if (powerComparison != 0) {
                return powerComparison;
            }
        }

        return 0;
    }

    private Type getTypeWithJAsWildcard(String input) {
        // May not be the best way of going about this.
        Type bestType = Type.HIGH_CARD;

        for (String card : cards) {
            if (bestType.power < getType(input.replace("J", card)).power) {
                bestType = getType(input.replace("J", card));
            }
        }

        return bestType;
    }

    private Type getType(String input) {
        // card, repeats
        HashMap<String, Integer> repeats = new HashMap<>();
        for (String card : input.split("")) {
            if (!repeats.containsKey(card)) {
                repeats.put(card, 1);
            } else {
                repeats.put(card, repeats.get(card) + 1);
            }
        }

        ArrayList<Pair<String, Integer>> orderedRepeats = new ArrayList<>();

        for (String card : repeats.keySet()) {
            orderedRepeats.add(new Pair<>(card, repeats.get(card)));
        }
        orderedRepeats.sort((pair1, pair2) -> pair2.getSecond().compareTo(pair1.getSecond()));

        if (orderedRepeats.get(0).getSecond() == 5) {
            return Type.FIVE_OF_A_KIND;
        }
        if (orderedRepeats.get(0).getSecond() == 4) {
            return Type.FOUR_OF_A_KIND;
        }
        if (orderedRepeats.get(0).getSecond() == 3 && orderedRepeats.get(1).getSecond() == 2) {
            return Type.FULL_HOUSE;
        }
        if (orderedRepeats.get(0).getSecond() == 3) {
            return Type.THREE_OF_A_KIND;
        }
        if (orderedRepeats.get(0).getSecond() == 2 && orderedRepeats.get(1).getSecond() == 2) {
            return Type.TWO_PAIR;
        }
        if (orderedRepeats.get(0).getSecond() == 2) {
            return Type.ONE_PAIR;
        }
        return Type.HIGH_CARD;
    }

    private int cardPower(String input) {
        for (int i = 0; i < cards.length; i++) {
            if (input.equals(cards[i])) {
                return i;
            }
        }

        return 0;
    }

    enum Type {
        FIVE_OF_A_KIND(7),
        FOUR_OF_A_KIND(6),
        FULL_HOUSE(5),
        THREE_OF_A_KIND(4),
        TWO_PAIR(3),
        ONE_PAIR(2),
        HIGH_CARD(1);

        public final int power;

        Type(int power) {
            this.power = power;
        }
    }
}

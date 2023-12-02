package dev.ampersanded.y2023.d2;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] games = input.split("\n");
        int total = 0;

        for (int i = 0; i < games.length; i++) {
            String game = games[i].split(":")[1];
            String[] sets = game.split(";");

            boolean ok = true;

            ArrayList<Integer> reds = new ArrayList<>();
            ArrayList<Integer> greens = new ArrayList<>();
            ArrayList<Integer> blues = new ArrayList<>();

            for (String set : sets) {
                set = set.replaceFirst(" ", "");

                int red = 0;
                int blue = 0;
                int green = 0;

                for (String reveal : set.split(", ")) {
                    String[] revealSplit = reveal.split(" ");

                    if (revealSplit[1].equals("red")) {
                        red += Integer.parseInt(revealSplit[0]);
                    }
                    if (revealSplit[1].equals("blue")) {
                        blue += Integer.parseInt(revealSplit[0]);
                    }
                    if (revealSplit[1].equals("green")) {
                        green += Integer.parseInt(revealSplit[0]);
                    }
                }

                reds.add(red);
                greens.add(green);
                blues.add(blue);
            }

            total += findLargest(reds) * findLargest(blues) * findLargest(greens);
        }

        return total + "";
    }

    private int findLargest(ArrayList<Integer> arrayList) {
        int max = arrayList.get(0);

        for (int i : arrayList) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }
}

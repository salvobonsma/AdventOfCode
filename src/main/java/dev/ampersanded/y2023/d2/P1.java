package dev.ampersanded.y2023.d2;

import dev.ampersanded.lib.AdventChallenge;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        String[] games = input.split("\n");
        int total = 0;

        for (int i = 0; i < games.length; i++) {
            String game = games[i].split(":")[1];
            String[] sets = game.split(";");

            boolean ok = true;

            for (String set : sets) {
                set = set.replaceFirst(" ", "");

                int red = 0;
                int green = 0;
                int blue = 0;

                for (String reveal : set.split(", ")) {
                    String[] revealSplit = reveal.split(" ");

                    if (revealSplit[1].equals("red")) {
                        red += Integer.parseInt(revealSplit[0]);
                    }
                    if (revealSplit[1].equals("green")) {
                        green += Integer.parseInt(revealSplit[0]);
                    }
                    if (revealSplit[1].equals("blue")) {
                        blue += Integer.parseInt(revealSplit[0]);
                    }
                }

                if (red > 12 || green > 13 || blue > 14) {
                    ok = false;
                }
            }

            if (ok) {
                total += i + 1;
            }
        }

        return total + "";
    }
}

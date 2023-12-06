package dev.ampersanded.y2015.d3;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Point;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        Point currentHouse = new Point();
        ArrayList<Point> deliveredHouses = new ArrayList<>();
        deliveredHouses.add(new Point(currentHouse));

        for (String move : input.split("")) {
            switch (move) {
                case "^" -> currentHouse.addY(1);
                case "v" -> currentHouse.addY(-1);
                case ">" -> currentHouse.addX(1);
                case "<" -> currentHouse.addX(-1);
            }

            boolean repeat = false;
            for (Point house : deliveredHouses) {
                if (house.equals(new Point(currentHouse))) {
                    repeat = true;
                }
            }
            if (!repeat) {
                deliveredHouses.add(new Point(currentHouse));
            }
        }

        return deliveredHouses.size() + "";
    }
}

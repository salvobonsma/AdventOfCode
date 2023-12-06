package dev.ampersanded.y2015.d3;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Point;

import java.util.ArrayList;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        Point currentHouse = new Point();
        Point roboCurrentHouse = new Point();
        ArrayList<Point> deliveredHouses = new ArrayList<>();
        deliveredHouses.add(new Point(currentHouse));

        for (int i = 0; i < input.split("").length; i++) {
            Point currentPoint = i % 2 == 0 ? currentHouse : roboCurrentHouse;

            switch (input.split("")[i]) {
                case "^" -> currentPoint.addY(1);
                case "v" -> currentPoint.addY(-1);
                case ">" -> currentPoint.addX(1);
                case "<" -> currentPoint.addX(-1);
            }

            boolean repeat = false;
            for (Point house : deliveredHouses) {
                if (house.equals(new Point(currentPoint))) {
                    repeat = true;
                }
            }
            if (!repeat) {
                deliveredHouses.add(new Point(currentPoint));
            }
        }

        return deliveredHouses.size() + "";
    }
}

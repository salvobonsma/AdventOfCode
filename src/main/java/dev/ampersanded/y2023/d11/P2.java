package dev.ampersanded.y2023.d11;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        ArrayList<String> lines = new ArrayList<>(Arrays.stream(input.split("\n")).toList());
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).replace(".", "").isEmpty()) {
                lines.set(i, lines.get(i).replace(".", "*"));
            }
        }

        ArrayList<String> columns = new ArrayList<>();
        for (int i = 0; i < lines.get(0).length(); i++) {
            for (String line : lines) {
                try {
                    columns.set(i, columns.get(i) + line.split("")[i]);
                } catch (Exception e) {
                    columns.add(line.split("")[i]);
                }
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).replace(".", "").replace("*", "").isEmpty()) {
                columns.set(i, columns.get(i).replace(".", "*"));
            }
        }

        ArrayList<String> expandedInputLines = new ArrayList<>();
        for (int i = 0; i < columns.get(0).length(); i++) {
            for (String column : columns) {
                try {
                    expandedInputLines.set(i, expandedInputLines.get(i) + column.split("")[i]);
                } catch (Exception e) {
                    expandedInputLines.add(column.split("")[i]);
                }
            }
        }

        ArrayList<Point> galaxies = new ArrayList<>();
        for (int y = 0; y < expandedInputLines.size(); y++) {
            for (int x = 0; x < expandedInputLines.get(y).split("").length; x++) {
                if (expandedInputLines.get(y).split("")[x].equals("#")) {
                    galaxies.add(new Point(
                            (x - getSpacesBefore(expandedInputLines.get(y), x)) + getSpacesBefore(expandedInputLines.get(y), x) * 1000000,
                            (y - getSpacesBefore(expandedInputLines, y)) + getSpacesBefore(expandedInputLines, y) * 1000000
                    ));
                }
            }
        }

        long total = 0;
        ArrayList<Point> otherGalaxies = new ArrayList<>(galaxies);
        for (Point galaxyA : galaxies) {
            for (Point galaxyB : otherGalaxies) {
                total += galaxyA.distance(galaxyB);
            }
            otherGalaxies.remove(galaxyA);
        }

        return total + "";
    }

    private int getSpacesBefore(String input, int i) {
        return input.substring(0, i).replace(".", "").replace("#", "").length();
    }

    private int getSpacesBefore(ArrayList<String> input, int i) {
        ArrayList<String> sublist = new ArrayList<>(input.subList(0, i));
        int total = 0;
        for (String line : sublist) {
            if (line.replace("*", "").isEmpty()) total++;
        }

        return total;
    }
}

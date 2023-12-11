package dev.ampersanded.y2023.d11;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Point;

import java.util.ArrayList;
import java.util.Arrays;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        ArrayList<String> lines = new ArrayList<>(Arrays.stream(input.split("\n")).toList());
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).replace(".", "").isEmpty()) {
                lines.add(i, lines.get(i));
                i++;
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
            if (columns.get(i).replace(".", "").isEmpty()) {
                columns.add(i, columns.get(i));
                i++;
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

        String expandedInput = String.join("\n", expandedInputLines);

        ArrayList<Point> galaxies = new ArrayList<>();
        for (int y = 0; y < expandedInputLines.size(); y++) {
            for (int x = 0; x < expandedInputLines.get(y).split("").length; x++) {
                if (expandedInputLines.get(y).split("")[x].equals("#")) galaxies.add(new Point(x, y));
            }
        }

        int total = 0;
        ArrayList<Point> otherGalaxies = new ArrayList<>(galaxies);
        for (Point galaxyA : galaxies) {
            for (Point galaxyB : otherGalaxies) {
                total += galaxyA.distance(galaxyB);
            }
            otherGalaxies.remove(galaxyA);
        }

        return total + "";
    }
}

package dev.ampersanded.y2022.d7;

import dev.ampersanded.lib.AdventChallenge;

import java.util.*;

public class P1 extends AdventChallenge {
    private final ArrayList<String> currentPath = new ArrayList<>();
    private final HashMap<String, Integer> dirSizes = new HashMap<>();

    @Override
    public String solve() {
        for (String line : input.split("\n")) {
            String[] lineSplit = line.split(" ");

            if (line.startsWith("$")) {
                if (lineSplit[1].equals("cd")) {
                    cd(lineSplit[2]);
                }
                continue;
            }
            if (line.startsWith("dir")) {
                continue;
            }

            addDirSize(String.join("/", currentPath), Integer.parseInt(lineSplit[0]));
        }

        

        return dirSizes.toString();
    }

    public void cd(String location) {
        if (location.equals("..")) {
            currentPath.remove(currentPath.size() - 1);
        } else {
            currentPath.add(location);
        }
    }

    public void addDirSize(String dir, int size) {
        dir = dir.replaceFirst("/", "");

        if (dirSizes.containsKey(dir)) {
            dirSizes.replace(dir, dirSizes.get(dir) + size);
        } else {
            dirSizes.put(dir, size);
        }
    }
}

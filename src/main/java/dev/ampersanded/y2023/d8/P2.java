package dev.ampersanded.y2023.d8;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;
import dev.ampersanded.lib.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        String[] directions = input.split("\n\n")[0].split("");
        String nodesString = input.split("\n\n")[1];

        // key, (keyA, keyB)
        HashMap<String, Pair<String, String>> nodes = new HashMap<>();

        for (String line : nodesString.split("\n")) {
            String[] keyPair = line.split("\\(")[1].split(", ");

            nodes.put(line.split(" ")[0], Pair.of(keyPair[0], keyPair[1].replace(")", "")));
        }

        ArrayList<String> currentNodes = new ArrayList<>();
        for (Map.Entry<String, Pair<String, String>> node : nodes.entrySet()) {
            if (getLast(node.getKey()).equals("A")) {
                currentNodes.add(node.getKey());
            }
        }

        ArrayList<Long> solvedNodes = new ArrayList<>();
        for (String node : currentNodes) {
            long steps = 0;

            while (!getLast(node).equals("Z")) {
                String direction = directions[(int) (steps % directions.length)];
                node = direction.equals("L") ? nodes.get(node).getFirst() : nodes.get(node).getSecond();

                steps++;
            }

            solvedNodes.add(steps);
        }

        // Easiest way to get the LCM for all the nodes.
        return solvedNodes.stream().reduce(Utils::lcm).orElse(-1L) + "";
    }

    private String getLast(String input) {
        return input.split("")[2];
    }
}

package dev.ampersanded.y2023.d8;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Pair;

import java.util.HashMap;

public class P1 extends AdventChallenge {
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

        int steps = 0;
        String lastKey = "AAA";
        while (!lastKey.equals("ZZZ")) {
            String direction = directions[steps % directions.length];
            System.out.println(direction);

            lastKey = direction.equals("L") ? nodes.get(lastKey).getFirst() : nodes.get(lastKey).getSecond();
            steps++;
        }

        return steps + "";
    }
}

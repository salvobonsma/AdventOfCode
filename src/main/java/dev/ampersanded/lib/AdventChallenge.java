package dev.ampersanded.lib;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AdventChallenge {
    public final String input;

    public AdventChallenge() {
        try {
            input = Files.readString(Paths.get("input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String solve() {
        return input;
    }

    public void printSolution() {
        System.out.println(solve());
    }
}

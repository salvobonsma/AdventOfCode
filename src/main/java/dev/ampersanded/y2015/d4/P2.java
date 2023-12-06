package dev.ampersanded.y2015.d4;

import dev.ampersanded.lib.AdventChallenge;
import dev.ampersanded.lib.Utils;

import java.util.Objects;

public class P2 extends AdventChallenge {
    @Override
    public String solve() {
        int num = 0;
        String firstFiveInHash = "";
        while (!firstFiveInHash.equals("000000")) {
            num++;
            firstFiveInHash = Objects.requireNonNull(Utils.stringToMD5(input + num)).substring(0, 6);
        }

        return num + "";
    }
}

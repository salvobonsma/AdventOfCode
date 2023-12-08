package dev.ampersanded.lib;

import java.util.ArrayList;
import java.util.Collections;

public class Utils {
    public static final String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
    public static final String[] vowels = "aeiou".split("");

    public static long lcm(long i, long y) {
        if (i == 0 || y == 0) {
            return 0;
        }
        return (i * y) / gcd(i, y);
    }

    public static long gcd(long i, long y) {
        while (y != 0) {
            long temp = y;
            y = i % y;
            i = temp;
        }
        return i;
    }

    public static ArrayList<Integer> orderLargestToSmallest(ArrayList<Integer> input) {
        input.sort(Collections.reverseOrder());
        return input;
    }

    public static String stringToMD5(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException ignored) {
        }
        return null;
    }
}

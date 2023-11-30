package dev.ampersanded.lib;

import java.util.ArrayList;
import java.util.Collections;

public class Utils {
    public static ArrayList<Integer> orderLargestToSmallest(ArrayList<Integer> input) {
        input.sort(Collections.reverseOrder());
        return input;
    }
}

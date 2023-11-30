package dev.ampersanded.y2022.d5;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        String drawing = input.split("\n\n", 2)[0];
        String instructions = input.split("\n\n", 2)[1];

        structureDrawing(drawing);

        return "";
    }

    public ArrayList<ArrayList<String>> structureDrawing(String drawing) {
        ArrayList<ArrayList<String>> structuredDrawing = new ArrayList<>();

        String[] layer = drawing.split("\n");
        for (int i = 0; i < layer.length - 1; i++) {
            structuredDrawing.add(new ArrayList<>());

            String[] crates = layer[i]
                    .replace("   ", "-")
                    .replace("[", "")
                    .replace("]", "")
                    .split(" ");
            for (String s : crates) {
                System.out.print(s);
            }
            System.out.println();
        }

//        for (int i = 0; i < input.split("\n").length; i++) {
//            structuredDrawing.add(new ArrayList<>());
//            String[] cratesLayer = input.split("\n")[i].replace("    ", " ").split("");
//            System.out.println(input.split("\n")[i]);
//
//            for (int i2 = 0; i < cratesLayer.length; i++) {
//                cratesLayer[i2] = cratesLayer[i2].replace("[", "").replace("]", "");
//
//                ArrayList<String> currentArray = structuredDrawing.get(i2);
//                currentArray.add(cratesLayer[i2]);
//
//                structuredDrawing.set(i2, currentArray);
//            }
//        }
        return null;
    }
}

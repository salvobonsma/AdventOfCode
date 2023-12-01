package dev.ampersanded.y2022.d5;

import dev.ampersanded.lib.AdventChallenge;

import java.util.ArrayList;

public class P1 extends AdventChallenge {
    @Override
    public String solve() {
        String[] instructions = input.split("\n\n", 2)[1].split("\n");

        ArrayList<ArrayList<String>> drawing = structureDrawing();

        for (String instruction : instructions) {
            String[] instructionParced = instruction.split(" ");

            for (int i = 0; i < Integer.parseInt(instructionParced[1]); i++) {
                move(drawing, Integer.parseInt(instructionParced[3]) - 1, Integer.parseInt(instructionParced[5]) - 1);
            }
        }

        System.out.println(drawing);

        return getTop(drawing.get(0)) + getTop(drawing.get(1)) + getTop(drawing.get(2)) + getTop(drawing.get(3)) +
                getTop(drawing.get(4)) + getTop(drawing.get(5)) + getTop(drawing.get(6)) + getTop(drawing.get(7)) +
                getTop(drawing.get(7));
    }

    private void move(ArrayList<ArrayList<String>> drawing, int a, int b) {
        String crate = getTop(drawing.get(a));

        drawing.get(a).remove(drawing.get(a).size() - 1);
        drawing.get(b).add(crate);
    }

    private String getTop(ArrayList<String> arrayList) {
        return arrayList.get(arrayList.size() - 1);
    }

    private ArrayList<ArrayList<String>> structureDrawing() {
        ArrayList<ArrayList<String>> structuredDrawing = new ArrayList<>();

        ArrayList<String> stack1 = new ArrayList<>();
        stack1.add("Q");
        stack1.add("F");
        stack1.add("M");
        stack1.add("R");
        stack1.add("L");
        stack1.add("W");
        stack1.add("C");
        stack1.add("V");

        ArrayList<String> stack2 = new ArrayList<>();
        stack2.add("D");
        stack2.add("Q");
        stack2.add("L");

        ArrayList<String> stack3 = new ArrayList<>();
        stack3.add("P");
        stack3.add("S");
        stack3.add("R");
        stack3.add("G");
        stack3.add("W");
        stack3.add("C");
        stack3.add("N");
        stack3.add("B");

        ArrayList<String> stack4 = new ArrayList<>();
        stack4.add("L");
        stack4.add("C");
        stack4.add("D");
        stack4.add("H");
        stack4.add("B");
        stack4.add("Q");
        stack4.add("G");

        ArrayList<String> stack5 = new ArrayList<>();
        stack5.add("V");
        stack5.add("G");
        stack5.add("L");
        stack5.add("F");
        stack5.add("Z");
        stack5.add("S");

        ArrayList<String> stack6 = new ArrayList<>();
        stack6.add("D");
        stack6.add("G");
        stack6.add("N");
        stack6.add("P");

        ArrayList<String> stack7 = new ArrayList<>();
        stack7.add("D");
        stack7.add("Z");
        stack7.add("P");
        stack7.add("V");
        stack7.add("F");
        stack7.add("C");
        stack7.add("W");

        ArrayList<String> stack8 = new ArrayList<>();
        stack8.add("C");
        stack8.add("P");
        stack8.add("D");
        stack8.add("M");
        stack8.add("S");

        ArrayList<String> stack9 = new ArrayList<>();
        stack9.add("Z");
        stack9.add("N");
        stack9.add("W");
        stack9.add("T");
        stack9.add("V");
        stack9.add("M");
        stack9.add("P");
        stack9.add("C");

        structuredDrawing.add(stack1);
        structuredDrawing.add(stack2);
        structuredDrawing.add(stack3);
        structuredDrawing.add(stack4);
        structuredDrawing.add(stack5);
        structuredDrawing.add(stack6);
        structuredDrawing.add(stack7);
        structuredDrawing.add(stack8);
        structuredDrawing.add(stack9);

        return structuredDrawing;
    }
}

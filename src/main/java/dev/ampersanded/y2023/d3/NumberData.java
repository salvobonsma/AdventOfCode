package dev.ampersanded.y2023.d3;

public class NumberData {
    int x;
    int y;
    int length;
    String number;

    public NumberData(int x, int y, int length, String number) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("(x: %d, y: %d, number: %s)", x, y, number);
    }
}

package dev.ampersanded.lib;

/**
 * Wrapper of Pair with tools usefully for points.
 */
public class Point {
    private Pair<Integer, Integer> point;

    public Point() {
        point = Pair.of(0, 0);
    }

    public Point(int x, int y) {
        point = Pair.of(x, y);
    }

    public int getX() {
        return point.getFirst();
    }

    public void setX(int x) {
        point = Pair.of(x, point.getSecond());
    }

    public int getY() {
        return point.getSecond();
    }

    public void setY(int y) {
        point = Pair.of(point.getFirst(), y);
    }

    public void addX(int x) {
        point = Pair.of(point.getFirst() + x, point.getSecond());
    }

    public void addY(int y) {
        point = Pair.of(point.getFirst(), point.getSecond() + y);
    }

    public void add(Point point) {
        add(point.getX(), point.getY());
    }

    public void add(int x, int y) {
        point = Pair.of(point.getFirst() + x, point.getSecond() + y);
    }

    public void set(Point point) {
        set(point.getX(), point.getY());
    }

    public void set(int x, int y) {
        point = Pair.of(x, y);
    }
}

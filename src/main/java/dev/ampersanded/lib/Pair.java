package dev.ampersanded.lib;

public class Pair<A, B> {
    private final A m_first;
    private final B m_second;

    public Pair(A first, B second) {
        m_first = first;
        m_second = second;
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    public A getFirst() {
        return m_first;
    }

    public B getSecond() {
        return m_second;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + "," + getSecond() + ")";
    }
}
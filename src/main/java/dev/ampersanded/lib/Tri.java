package dev.ampersanded.lib;

public class Tri<A, B, C> {
    private final A m_first;
    private final B m_second;
    private final C m_third;

    public Tri(A first, B second, C third) {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public static <A, B, C> Tri<A, B, C> of(A a, B b, C c) {
        return new Tri<>(a, b, c);
    }

    public A getFirst() {
        return m_first;
    }

    public B getSecond() {
        return m_second;
    }

    public C getThird() {
        return m_third;
    }

    @Override
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ", " + getThird() + ")";
    }
}
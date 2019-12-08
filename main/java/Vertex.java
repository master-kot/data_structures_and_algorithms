package main.java;

import java.util.Objects;

public class Vertex {

    boolean visit;
    int number;

    public Vertex(int number) {
        this.number = number;
        visit = false;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        return number == ((Vertex)o).number;
    }

    @Override
    public  int hashCode() {
        return Objects.hash(number);
    }
}

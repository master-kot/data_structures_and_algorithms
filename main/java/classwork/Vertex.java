package main.java.classwork;

import java.util.ArrayList;
import java.util.Objects;

public class Vertex {

    public boolean visit;
    int number;

    public Vertex(int number) {
        this.number = number;
        visit = false;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

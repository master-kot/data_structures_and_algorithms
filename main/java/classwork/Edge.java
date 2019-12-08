package main.java.classwork;

public class Edge {

    Vertex start, end;
    boolean visit;

    public Edge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
        visit = false;
    }
}

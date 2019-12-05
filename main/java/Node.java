package main.java;

public class Node<T> {
    T value;
    int depth;
    Node<T> parent, left, right;

    public Node(T value) {
        this.value = value;
        left = right = null;
    }
}

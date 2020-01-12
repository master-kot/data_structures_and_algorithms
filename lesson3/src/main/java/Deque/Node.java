package Deque;

public class Node<T> {

    T value;
    Node<T> prev, next;

    public Node(T value) {
        this.value = value;
    }
}

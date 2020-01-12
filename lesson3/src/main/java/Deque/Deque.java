package Deque;

public class Deque<T> {

    private Node<T> head, tail;
    private int size;

    public Deque() {
        head = tail = null;
        size = 0;
    }

    public void addBack(T value){
        if(size == 0){
            head = tail = new Node<T>(value);
            size++;
            return;
        }
        Node<T> node = new Node<T>(value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }
}

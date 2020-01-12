package Stack;

public class Node<T> {

    private T value;
    private Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.prev = null;
    }

    public T getValue() {
        return value;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return prev;
    }
}
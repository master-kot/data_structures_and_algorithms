package Stack;

import java.util.Iterator;

public class Stack<T> implements LIFO<T> {
    /**
     * Реализовать класс стека, имеющий медоды соответственно интерфейсу LIFO
     */
    private Node<T> tail;
    private int size;

    public Stack() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    // TODO: 18/11/2019
    @Override
    public T pop() {
        if(tail == null) {
            return null;
        }
        T tmp = tail.getValue();
        tail = tail.getPrev();
        size--;
        return tmp;
    }

    // TODO: 18/11/2019
    @Override
    public T top() {
        if(tail == null) {
            return null;
        }
        return tail.getValue();
    }

    // TODO: 18/11/2019
    @Override
    public void push(T value) {
        Node<T> node = new Node(value);
        if (size != 0) {
            node.setPrev(tail);
        }
        tail = node;
        size++;
    }

    // TODO: 18/11/2019
    @Override
    public void show() {
        Node<T> node  = tail;
        while (node != null){
            System.out.print(node.getValue() + " ");
            node = node.getPrev();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        Node<T> tmp = tail;
        StringBuilder sb = new StringBuilder();
        if (tmp != null) {
            sb.append(tmp.getValue());
            while (tmp.getPrev() != null) {
                tmp = tmp.getPrev();
                sb.append(" ").append(tmp.getValue());
            }
        }
        return sb.toString();
    }

    private Node<T> iterNode;

    @Override
    public Iterator<T> iterator() {
        iterNode = tail;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iterNode != null;
            }

            @Override
            public T next() {
                T val = iterNode.getValue();
                iterNode = iterNode.getPrev();
                return val;
            }
        };
    }
}
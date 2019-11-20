package main.java.Stack;

import main.java.classWork.queue.LinkedQueue;
import main.java.classWork.queue.QueuePointerException;

import java.util.Iterator;

public class Stack<T> implements LIFO<T> {

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

    @Override
    public T pop() {
        // TODO: 18/11/2019
        if(tail == null) {
            throw new StackPointerException("pop from empty queue");
        }
        T tmpValue = tail.getValue();
        tail = tail.getPrev();
        size--;
        return tmpValue;
    }

    @Override
    public T top() {
        if(tail == null) {
            throw new StackPointerException("top from empty queue");
        }
        return tail.getValue();
    }

    @Override
    public void push(T value) {
        // TODO: 18/11/2019
        Node node = new Node(value);
        if (size == 0) {
            tail = node;
        } else {
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    @Override
    public void show() {
        // TODO: 18/11/2019
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

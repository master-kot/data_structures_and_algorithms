package Queue;

import java.util.Iterator;

public class LinkedQueue implements Fifo {

    Node iteratorNode;

    @Override
    public Iterator<Integer> iterator() {

        iteratorNode = head;

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return iteratorNode != null;
            }

            @Override
            public Integer next() {
                int val = iteratorNode.value;
                iteratorNode = iteratorNode.next;
                return val;
            }
        };
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private Node head, tail;
    private int size;

    public LinkedQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void push(int element) {
        Node node = new Node(element);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public int pop() {
        if(head == null) {
            throw new IndexOutOfBoundsException(("top from empty queue");
        }
        size--;
        int tmp = head.value;
        head = head.next;
        return tmp;
    }

    @Override
    public int top() {
        if(head == null) {
            throw new IndexOutOfBoundsException(("top from empty queue");
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}

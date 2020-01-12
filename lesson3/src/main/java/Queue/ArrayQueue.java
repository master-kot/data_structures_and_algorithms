package Queue;

import java.util.Iterator;

public class ArrayQueue implements Fifo {

    private int size, pointer, capacity;
    private int [] data;

    public ArrayQueue() {
        size = pointer = 0;
        capacity = 128;
        data = new int[capacity];
    }

    private void reallocate() {
        capacity *= 2;
        int [] tmp = new int[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp,
                0, size);
        data = tmp;
    }

    @Override
    public void push(int element) {
        if (capacity <= size) {
            reallocate();
        }
        data[size++] = element;
    }

    @Override
    public int pop() {
        if(pointer >= size) {
            throw new IndexOutOfBoundsException("pop from empty queue");
        }
        return data[pointer++];
    }

    @Override
    public int top() {
        if (size == 0){
            throw new IndexOutOfBoundsException("top from empty queue");
        }
        return data[pointer];
    }

    @Override
    public boolean isEmpty() {
        return pointer >= size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}

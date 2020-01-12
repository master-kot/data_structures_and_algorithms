package Queue;

import java.util.Iterator;

public class ArrayPriorityQueue implements Fifo {

    private int[] data;
    private int rootIndex, size, capacity;

    public ArrayPriorityQueue() {
        size = 0;
        rootIndex = 1;
        capacity = 128;
        data = new int[capacity];
    }

    private void reallocate() {
        capacity *= 2;
        int[] tmp = new int[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp,
                0, size);
        data = tmp;
    }

    @Override
    public void push(int element) {
        if (size >= capacity) {
            reallocate();
        }
        if(size == 0) {
            data[1 + size++] = element;
        }
        else {
            data[1 + size++] = element;
            int pointer = size - 1;
            while (data[pointer] < data[pointer / 2]) {
                swap(pointer, pointer / 2);
                pointer = pointer / 2;
                if (pointer < rootIndex) break;
            }
        }
    }

    private void swap(int i1, int i2) {
        int tmp = data[i1];
        data[i1] = data[i2];
        data[i2] = tmp;
    }

    @Override
    public int pop() {
        //O(logN)
        int min = data[rootIndex];
        data[rootIndex] = data[size];
        size--;
        int pointer = rootIndex;
        while (Math.min(data[2 * pointer], data[2 * pointer + 1]) < data[pointer]) {
            if (2 * pointer > size) break;
            if (data[2 * pointer] < data[2 * pointer + 1]) {
                swap(2 * pointer, pointer);
                pointer = 2 * pointer;
            } else {
                swap(2 * pointer + 1, pointer);
                pointer = 2 * pointer + 1;
            }
        }
        return min;
    }

    @Override
    public int top() {
        //О(1)
        return data[rootIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    int first;

    @Override
    public Iterator<Integer> iterator() {
        first = 1;

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return first <= size;
            }

            @Override
            public Integer next() {
                return data[first++];
            }
        };
    }
}

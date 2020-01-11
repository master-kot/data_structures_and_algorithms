public class DArray<T> {

    private int size, capacity;
    private Object [] data;

    public DArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    /**
     * Метод увеличения размера массива
     */
    private void reallocate() {
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        if (size >= 0) {
            System.arraycopy(data, 0, tmp, 0, size);
        }
        data = tmp;
    }

    /**
     * Реализовать вставку элемента в конец массива
     */
    public void add(T value){
        if (size >= capacity) {
            reallocate();
        }
        data[size] = value;
        size++;
    }

    //TODO
    /**
     * Реализовать вставку элемента по индексу
     */
    public void add(int index, T value) {
        if (size >= capacity) {
            reallocate();
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = value;
        size ++;
    }

    public boolean remove () {
        size--;
        return size>=0;
    }

    //TODO
    /**
     * Реализовать удаление элемента по индексу
     */
    public boolean remove(int index) {
        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    //TODO
    /**
     * Вывести элементы в виде строки вида: [1, 2, 3, 4, 5]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size-1]).append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index) {
        return (T) data[index];
    }
}
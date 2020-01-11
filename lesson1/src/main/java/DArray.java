public class DArray<T> {

    private int size, capacity;
    private Object [] data;

    public DArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    private void reallocate(){
        System.err.println("array was reallocated " + capacity);
        capacity *= 2;
        Object [] tmp = new Object[capacity];
        if (size >= 0) {
            System.arraycopy(data, 0,
                    tmp, 0, size);
        }
        data = tmp;
    }

    public void add(T value){
        if(size < capacity) {
            data[size] = value;
            size++;
        } else {
            reallocate();
            data[size] = value;
            size++;
        }
    }

    //TODO
    /**
     * Реализовать вставку в массив по индексу
     */
    public void add(int index, T value) {
        Object [] tmp = new Object[++capacity];
        System.arraycopy(data, 0, tmp, 0, index);
        tmp[index] = value;
        System.arraycopy(data, index, tmp, index + 1, size - index);
        data = tmp;
        size++;
    }

    //TODO
    /**
     * Реализовать удаление по индексу
     */
    public void remove(int index) {
        Object [] tmp = new Object[--capacity];
        System.arraycopy(data, 0, tmp, 0, index);
        System.arraycopy(data, index+1, tmp, index, --size - index);
        data = tmp;
    }

    //TODO
    /**
     * Вывести массив элементов в виде такой строки: [1, 2, 3, 4, 5]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size]).append("]");
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
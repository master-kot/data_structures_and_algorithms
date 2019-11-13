package datas.lesson1.classwork;

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

    public void add(int index, T value){
        //TODO
        Object [] tmp = new Object[++capacity];
        System.arraycopy(data, 0, tmp, 0, index);
        tmp[index] = value;
        System.arraycopy(data, index, tmp, index + 1, size - index);
        data = tmp;
        size++;
    }

    public void remove(int index){
        //TODO
        Object [] tmp = new Object[--capacity];
        System.arraycopy(data, 0, tmp, 0, index);
        System.arraycopy(data, index+1, tmp, index, --size - index);
        data = tmp;
    }

    @Override
    public String toString() {
        //TODO
        //String like [1, 2, 3, 4, 5]
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index){
        return (T) data[index];
    }
}
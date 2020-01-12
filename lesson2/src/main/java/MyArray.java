public class MyArray <T extends Comparable<T>> {
    /**
     * Задача: реализовать методы самописного класса ArrayList
     */
    private Object[] data;
    private int size, capacity;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Object[capacity];
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
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

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int size(){
        return size;
    }

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
     * Метод удаления последнего элемента массива
     */
    public boolean remove () {
        size--;
        return size>=0;
    }

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

    //TODO
    /**
     * Метод должен возвращать массив размером size
     */
    public T[] toArray(){
        Object[] dataArray = new Object[size];
        System.arraycopy(data, 0, dataArray, 0, size);
        return (T[]) dataArray;
    }

    //TODO
    /**
     * Метод линейного поиска, должен возвращать индекс первого
     * найденного элемента или -1, если такого нет
     */
    public int linearSearch(T element){
        for (int i = 0; i < size; i++) {
            if (((T)data[i]).compareTo(element) == 0) return i;
        }
        return -1;
    }

    //TODO
    /**
     * Тип data - Object, для сортировки нужен сравнимый тип именного его передаем внутрь
     * Поскольку класс Объект родитель всего справедлива следующая запись:
     * ((T)arrayElement).compareTo(T otherElement)
     * Объект приведенный к типу Т, будет иметь метод сравнения
     */
    public void insertSort(){
    }

    //TODO
    /**
     * Метод должен вернуть пару из значения элемента и количества раз,
     * которое он встретился в массиве data. вернуть нужно пару,
     * элемент которой встретился наибольшее количество раз
     * Если таковых элементов много, нужно вернуть тот, у которого значение наибольшее
     * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
     * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
     * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
     * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
     */
    public Pair<T> taskMaxCount(){
        bubbleSort();
        int cnt = 1, max = 0;
        T element = null;
        for (int i = 0; i < size - 1; i++) {
            if (((T) data[i]).compareTo((T) data[i + 1]) == 0) {
                cnt++;
            } else {
                if (cnt >= max) {
                    max = cnt;
                    element = (T) data[i];
                }
                cnt = 1;
            }
        }
        return new Pair<T>(element, cnt);
    }

    //TODO
    /**
     * Метод сортировки "пузырьком"
     */
    public void bubbleSort(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((T)data[j]).compareTo((T)data[j + 1]) > 0) {
                    Object tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    //TODO
    /**
     * Метод скоростной сортировки, сложность сортировки - O(NlogN)
     */
    public void quickSort() {
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
    }
}
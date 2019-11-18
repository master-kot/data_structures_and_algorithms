
import java.lang.Object;
import java.util.Arrays;
import java.util.Comparator;

public class MyArray<T extends Comparable<T>> {

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

    public void add(T element){
        if(size >= capacity){
            reallocate();
        }
        data[size] = element;
        size++;
    }

    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public int size(){
        return size;
    }

    public void add(int index, T element){
        if(size >= capacity){
            reallocate();
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data,
                        index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    private void reallocate(){
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp,
                0, size);
        data = tmp;
    }

    public boolean remove(){
        size--;
        return size >= 0;
    }

    public boolean remove(int index){
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    /*
     * Метод должен возвращать массив размером size
     * */
    public T [] toArray(){
        //TODO
        T[] toArray = new T[size];
        System.arraycopy(data, 0, dataArray, 0, size);
        return toArray;
    }

    /*
    * Метод должен возвращать индекс первого найденного элемента
    * или -1, если такого нет
    * */
    public int linearSearch(T element){
        //TODO
        for (int i = 0; i < size; i++) {
            if (((T)data[i]).compareTo(element)) return i;
        }
        return -1;
    }

    /*
     * Тип data - Object, но для сортировки нам нужен сравнимый тип
     * мы именного его передаем внутрь
     * Поскольку класс Объект родитель всего
     * справедлива следующая запись: ((T)arrayElement).compareTo(T otherElement)
     * Объект приведенный к типу Т, будет иметь метод сравнения
     * */
    public void insertSort(){
        //TODO
    }

    static class Pair<T> {
        T element;
        Integer counter;

        public Pair(T element, Integer counter) {
            this.element = element;
            this.counter = counter;
        }
    }

    /*
    * Метод должен вернуть пару из значения элемента
    * и количества раз, которое он встретился в массиве data
    * вернуть нужно пару, элемент которой встретился наибольшее количество раз
    * А если таквых элементов много, то нужно вернуть тот, у которого значение наибольшее
    * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
    * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
    * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
    * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
    * */
    public Pair<Integer> taskMaxCount(){
        //TODO
        int biggerElemant;
        int[] value = new int[size];
        int[] amount = new int[size];
        int numberMaxMember = 0;
        int maxMember = data[0];
        int counterRare = 0;
        int numberRare = 0;
        for (int i = 0; i <size; i++){
            for (int j = 0; j <= i; j++) {
                if (data[i] == value[j]) {
                    amount[i]++;
                }
            }
            if (amount[i] > counterRare) {
                counterRare = amount[i];
                numberRare = i;
            }
            if (amount[i] == 0) {
                value[i] = data[i];
                amount[i] = 1;
                if (value[i] > maxMember) {
                    maxMember = value[i];
                    numberMaxMember = i;
                }
            }
        }
        if (counterRare > 1) {
            Pair<Integer> integerPair = new Pair(value[numberRare], counterRare);
            return integerPair;
        } else {
            Pair<Integer> integerPair = new Pair(maxMember, numberMaxMember);
            return integerPair;
        }
    }

    public class Pair<Integer> {

        private final Integer left;
        private final Integer right;

        public Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }

        public Integer getLeft() {
            return left;
        }

        public Integer getRight() {
            return right;
        }
    }


    public void bubbleSort(){
        //TODO
        T tmp = new T;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if(data[j].compareTo(data[j+1]) > 0){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }
    /*
     * Задача под звездочкой
     * решается опционально, кому интересно
     * O(NlogN)
     * */
    public void quickSort(){
        //TODO
    }

    private void quickSort(int left, int right) {
        //TODO
    }

    public static void main(String[] args) {
        MyArray<String> arr = new MyArray<>();
        for (int i = 0; i < 100000; i++) {
            arr.add("i+1");
        }

        System.out.println(Arrays.toString(arr.toArray()));
    }

}
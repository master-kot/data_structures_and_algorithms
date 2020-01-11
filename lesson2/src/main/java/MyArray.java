
import java.lang.Object;
import java.util.Arrays;
import java.util.Comparator;

public class MyArray<T extends Comparable<T>> {
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
/*        T[] dataArray = new T[size];
        System.arraycopy(data, 0, dataArray, 0, size);
*/        return null; //dataArray;
    }

    //TODO
    /**
    * Метод должен возвращать индекс первого найденного элемента
    * или -1, если такого нет
    */
    public int linearSearch(T element){
        for (int i = 0; i < size; i++) {
//            if (((T)data[i]).compareTo(element)) return i;
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
     * Если таквых элементов много, нужно вернуть тот, у которого значение наибольшее
     * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
     * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
     * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
     * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
     */
    public Pair<Integer> taskMaxCount(){
/*        int biggerElemant;
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
        }*/
        return null;
    }

    //TODO
    /**
     * Метод сортировки "пузырьком"
     */
    public void bubbleSort(){
        //T tmp = new T;
        for (int i = 0; i < size; i++) {
/*            for (int j = 0; j < size - i - 1; j++) {
                if(data[j].compareTo(data[j+1]) > 0){
                    tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
*/
        }
    }

    //TODO
    /**
     * Задача под звездочкой, решается опционально, O(NlogN)
     */
    public void quickSort() {
    }

    //TODO
    /**
     *
     */
    private void quickSort(int left, int right) {
    }
}
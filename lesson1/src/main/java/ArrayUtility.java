import java.util.Arrays;
import java.util.Collections;

public class ArrayUtility {
    /**
     * Класс для работы с переменными типа int (не с обобщениями)
     */
    private int [] data;
    public ArrayUtility(int[] data) {
        this.data = data;
    }

    //TODO
    /**
     * функция должна возвращать сумму элементов массива
     */
    public long arraySum(){
        long sum = 0L;
        for (int i = 0; i < data.length; i++) {
            sum += (long) data[i];
        }
        return sum;
    }

    //TODO
    /**
     * функция должна возвращать среднее арифметическое элементов массива
     */
    public double avg(){
        return ((double) arraySum()) / ((double) data.length);
    }

    //TODO
    /**
     * функция должна возвращать медиану массива. медиана - это элемент посередине
     * в упорядоченном массиве для нечетных длин массива
     * или среднее арифметическое двух соседних элементов посередине для четных длин
     * 1 2 3 4 5 -> 3;    1 2 3 4 - (2 + 3) / 2 = 2,5
     */
    public double median(){
        //TODO
        int halfSize = data.length / 2;
        double medianValue;
        if (data.length %2 == 0) {
            medianValue = (double) (data[halfSize - 1] + data[halfSize]) / 2d;
        } else  {
            medianValue = (double) data[halfSize];
        }
        return medianValue;
    }
}
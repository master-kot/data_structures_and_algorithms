package main.java;

//import javafx.util.Pair;

import jdk.internal.util.xml.impl.Pair;

import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RFunctions {

    //функция должна находить число Фибоначчи с номер н
    public BigInteger fib(int n){
    //public int fib(int n){
        //TODO
        if (n == 0) return new BigInteger(String.valueOf(0));
        if (n == 1) return new BigInteger(String.valueOf(1));
        if (n == 2) return new BigInteger(String.valueOf(1));
        return new BigInteger(String.valueOf(fib(n-1).add(fib(n-2))));
    }

    //функция должна считать факториал числа n*factor(n-1)
    public BigInteger factor(int n){
        //TODO
        if (n == 0) return new BigInteger(String.valueOf(0));
        if (n == 1) return new BigInteger(String.valueOf(1));
        return factor(n-1).multiply(new BigInteger(String.valueOf(n)));
    }

    //функция должна вводить числа из in до тех пор пока не будет введен 0
    //и вывести в out все числа в обратном порядке без 0
    public void reverse(Scanner in, PrintWriter out){
        //TODO
        
    }

    //функция должна отсортировать массив слиянием
    public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
        //TODO
        Integer[] arrayOfList = new Integer[list.size()];
        list.toArray(arrayOfList);

        return null;
    }


    //функция должна разбить список пополам (2 2 для 4 или 3 2 для 5)
/*    Pair<ArrayList<Integer>, ArrayList<Integer>>
    split(ArrayList<Integer> list){
        //TODO
        return null;
    }*/

    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        //TODO
        return null;
    }

    static boolean [] used;
    static int cnt = 0;
    //функция должна вернуть К-ую перестановку n-элементного множества
    //уникальных целых чисел дата
    int [] permutation(int [] data, int n, int k, int index, PrintWriter out){
        //TODO
        if(index == n){
            cnt++;
            if(cnt == k){
                out.println(Arrays.toString(data));
                return data;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(used[i]) continue;
            data[index] = i;
            used[i] = true;
            permutation(data, n, k, index+1, out);
            used[i] = false;
        }
        return data;
    }

    //функция должна вернуть максимальную массу из предметов в дата, но не превышающую
    //лимит
    long knackPack(int [] data, long limit){
        return knackPack(data, limit, 0, 0);
    }

    private long knackPack(int [] data, long W, long sum, int index){
        if(W < 0) return Long.MIN_VALUE;
        if(index == data.length) return sum;
        return Math.max(knackPack(data, W - data[index], sum + data[index], index + 1),
                knackPack(data, W, sum, index + 1));
    }

}

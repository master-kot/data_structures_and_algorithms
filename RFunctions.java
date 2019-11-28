package main.java;

//import javafx.util.Pair;
//import jdk.internal.util.xml.impl.Pair;

import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RFunctions {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
		RFunctions rFunctions = new RFunctions();
        int n = 0;
        System.out.println(rFunctions.fib(n));
        System.out.println(rFunctions.factor(n));
		rFunctions.reverse(in, out);
		
	}

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
        int x = in.nextInt();
		if (x == 0) return;
		reverse();
		try {
			out.println(x);
		}
    }

    //функция должна отсортировать массив слиянием
    //public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
	//реализована сортировка слиянием в массив, 
	//сортировка списков сделать не успел(
	public int[] mergeSort(int[] arrayAll){
        //TODO
		//заготовка для метода работающего с списком
		//int [] arrayAll = new int[list.size()];
		//System.arraycopy(list.toArray(), 0, arrayAll, 0, list.size());
		
		if (list == null) {
			return null;
		}
				
		if (arrayAll.length < 2) {
			return arrayAll;
		}
		int [] arrayLeft = new int[arrayAll.length / 2];
		System.arraycopy(arrayAll, 0, arrayLeft, 0, arrayAll.length / 2);
		
		int [] arrayRight = new int[arrayAll.length - arrayAll.length / 2];
		System.arraycopy(arrayAll, arrayAll.length / 2, arrayRight, 0, arrayAll.length - arrayAll.length / 2);
		
		arrayLeft = mergeSort(arrayLeft);
		arrayRight = mergeSort(arrayRight);
		
		return mergeArray(arrayLeft, arrayRight);
    }
	
	public class Pair <T element> {
		private T left;
		private T right;
		
		public Pair (T left, T right){
			this.left = left;
			this.right = right;
		}
		
		public T getRight {
			return right;
		}
		
		public T getLeft {
			return left;
		}
	}
	
    //функция должна разбить список пополам (2 2 для 4 или 3 2 для 5)
	//не успел реализовать, однако планирую использовать наработку из 
	//метода mergeSort реализованного выше для массива
    Pair<ArrayList<Integer>, ArrayList<Integer>> split(ArrayList<Integer> list){
        //TODO
        return null;
    }

    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    //public ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
    //заготовка метода работающего со списком, пока что работающий с массивами
	//TODO
	public int [] mergeArray(int [] arrayLeft, int [] arrayRight) {
		int [] mergedArray = int[arrayLeft.length + arrayRight.length];
		int positionLeft = 0, positionRight = 0;

		for (int i = 0; i < mergedArray.length; i++) {
			if (positionLeft == arrayLeft.length){
				mergedArray[i] = arrayRight[i - positionRight];
				positionRight++;
			} else if (positionRight == arrayRight.length) {
				mergedArray[i] = arrayLeft[i - positionLeft];
				positionLeft++;
			} else if (arrayLeft[i - positionLeft] < arrayRight[i - positionRight]) {
				mergedArray[i] = arrayLeft[i - positionLeft];
				positionRight++;
			} else {
				mergedArray[i] = arrayRight[i - positionRight];
				positionLeft++;
			}
		}
		return mergedArray;
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

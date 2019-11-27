package main.java;

//import javafx.util.Pair;

import jdk.internal.util.xml.impl.Pair;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        RFunctions rFunctions = new RFunctions();
        int n = 0;
        System.out.println(rFunctions.fib(n));
        System.out.println(rFunctions.factor(n));
//        rFunctions.reverse(in, out);
    /*



        in = new Scanner(System.in);
        memo = new long[1000];
        used = new boolean[1000];
        rec(new int[]{0, 0, 0, 0}, 0);
    }

    static boolean [] used;

    static void rec(int [] data, int index){
        if(index == data.length){
            System.out.println(Arrays.toString(data));
            return;
        }
        for (int i = 0; i < data.length; i++) {
            if(used[i+1]) continue;
            data[index] = i+1;
            used[i+1] = true;
            rec(data, index+1);
            used[i+1] = false;
        }
    }

    static int cnt = 0;
    static long [] memo;

    static long f(int n){
        cnt++;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(memo[n] > 0) return memo[n];
        memo[n] = f(n - 1) + f(n - 2);
        return memo[n];
    }

    BigInteger fib(int n){
        return null;
    }

    BigInteger factor(int n){
        return null;
    }

    void reverse(Scanner in, PrintWriter out){

    }

    void mergeSort(ArrayList<Integer> list){

    }

  /*  Pair<ArrayList<Integer>, ArrayList<Integer>> split(ArrayList<Integer> list){

        return null;
    }

    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){

        return null;
    }

    void permutation(int [] data, int n, int k, int index){

    }

    long knackPack(int [] data, long limit, long  start, int index, ArrayList<Integer> list){
        return 0;
    }
    */
    }
}
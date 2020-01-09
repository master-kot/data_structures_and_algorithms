import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    protected Duration timeout = Duration.ofSeconds(30);
    protected MyArray.Pair pair;

    @Test
    public void maxCounterTest(){
        int [] test = new int[]{1, 1, 3, 2, 1, 2, 4, 2, 2, 5};
        MyArray<Integer> arr = new MyArray<>();
        for (int el : test) arr.add(el);
        pair = arr.taskMaxCount();
        assertEquals(2, pair.element);
        assertEquals(4, pair.counter);
        arr.add(1);
        arr.add(1);
        pair = arr.taskMaxCount();
        assertEquals(1, pair.element);
        assertEquals(5, pair.counter);
        arr.add(2);
        assertEquals(2, pair.element);
        assertEquals(5, pair.counter);
    }

    @Test
    public void timeTestAdd(){
        Random rnd = new Random();
        assertTimeoutPreemptively(timeout, ()->{
            MyArray<Integer> array = new MyArray<>();
            for (int i = 0; i < 1000000; i++) {
                array.add(rnd.nextInt());
            }
            for (int i = 0; i < 100000; i++) {
                array.add(5, rnd.nextInt());
            }
        });
        System.out.println("Add Test passed!");
    }

    @Test
    public void utilTest(){
        int [] data = new int[]{1,2,3,4,5,6,7,8,9,10};
        MyArray<Integer> arr = new MyArray<>();
        for(int i : data) arr.add(i);
        arr.remove();
        assertArrayEquals(new Integer[]{1,2,3,4,5,6,7,8,9}
        , arr.toArray());
        arr.remove(2);
        assertArrayEquals(new Integer[]{1,2,4,5,6,7,8,9}
                , arr.toArray());
        assertEquals(-1, arr.linearSearch(20));
        assertEquals(2, arr.linearSearch(4));
        arr.add(0, 100);
        assertArrayEquals(new Integer[]{100, 1,2,4,5,6,7,8,9}
                , arr.toArray());
        arr.add(3, 100);
        assertArrayEquals(new Integer[]{100,1,2,100,4,5,6,7,8,9}
                , arr.toArray());
        for (int i = 0; i < 100; i++) {
            arr.remove();
        }
        assertEquals(0, arr.size());
        for (int i = 0; i < 10; i++) {
            arr.add(0, i);
        }
        assertArrayEquals(new Integer[]{9,8,7,6,5,4,3,2,1,0}
                , arr.toArray());
    }

    String path = "/Users/levinmk/IdeaProjects/AS_geek_brains/lesson2/src/main/resources/";



    @Test
    public void sortTests1(){
        File in = new File(path + "sort.txt"),
                out = new File(path + "sort.ans");
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner ans = new Scanner(out);
            while (ans.hasNext()) list.add(ans.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(list.subList(0, 10));
        MyArray<Integer> array = new MyArray<>();
        Scanner input = null;
        try {
            input = new Scanner(in);
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                array.add(input.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTimeoutPreemptively(timeout, array::bubbleSort);
        assertArrayEquals(list.toArray(), array.toArray());
    }

    @Test
    public void sortTests2(){
        File in = new File(path + "sort.txt"),
                out = new File(path + "sort.ans");
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner ans = new Scanner(out);
            while (ans.hasNext()) list.add(ans.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(list.subList(0, 10));
        MyArray<Integer> array = new MyArray<>();
        Scanner input = null;
        try {
            input = new Scanner(in);
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                array.add(input.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTimeoutPreemptively(timeout, array::insertSort);
        assertArrayEquals(list.toArray(), array.toArray());
    }

/*
    Optional
    @Test
    void sortTests3(){
        File in = new File(path + "sort.txt"),
                out = new File(path + "sort.ans");
        ArrayList<Integer> list = new ArrayList<>();

        try {
            Scanner ans = new Scanner(out);
            while (ans.hasNext()) list.add(ans.nextInt());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(list.subList(0, 10));
        MyArray<Integer> array = new MyArray<>();
        Scanner input = null;
        try {
            input = new Scanner(in);
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                array.add(input.nextInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTimeoutPreemptively(Duration.ofSeconds(1), array::quickSort);
        assertArrayEquals(list.toArray(), array.toArray());
    }
    */
}

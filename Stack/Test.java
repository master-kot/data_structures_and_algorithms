package main.java.Stack;

import main.java.classWork.queue.ArrayPriorityQueue;
import main.java.classWork.queue.Fifo;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        LIFO<Integer> stack = new Stack<>();

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(r.nextInt(100));
            System.out.print(stack.top() + " ");
        }

        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.println("pop = " + stack.pop() + ", size = " + stack.size());
        }

//        stack.forEach(System.out::println);
//        while (!stack.iterator().hasNext()) { System.out.print(stack.pop() + " "); }
    }
}

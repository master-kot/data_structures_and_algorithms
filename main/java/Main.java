package main.java;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(5);
        tree.add(1);
        tree.add(7);
//        tree.add(3);
//        tree.add(8);
//        tree.add(2);
//        tree.add(10);
//        tree.add(12);
//        tree.add(0);
//        tree.add(-3);
        for (int i = 0; i < 13; i++) {
            System.out.println(i + " " + tree.find(i));
        }

//        System.out.println(tree.inOrder());
        System.out.println(tree.preOrder());
        tree.remove(1);
        System.out.println(tree.preOrder());
        tree.remove(7);
        System.out.println(tree.preOrder());
        tree.remove(10);
        System.out.println(tree.preOrder());
        tree.remove(5);
        System.out.println(tree.preOrder());
    }
}

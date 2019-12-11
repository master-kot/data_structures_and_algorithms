package main.java;

import java.util.ArrayList;

import static java.lang.Math.max;

public class MyHashSet<T> {

    private int size, capacity, maxDepth;
    private Node<T> [] table;
    //LinkedList<T> [] table

    public MyHashSet() {
        size = 0;
        capacity = 17;
        maxDepth = 0;
        table = (Node<T>[]) new Object[capacity];
        //При запуске класса на исполнение вышестоящая строка вызывает занный эксепшн
        //Почему и как это поправить???
        //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Lmain.java.Node;
        //	at main.java.MyHashSet.<init>(MyHashSet.java:17)
        //	at main.java.classwork.main(classwork.java:5)
    }

    public int size(){
        return size;
    }

    public void add(T value){
        int idx = hash(value);
        if (table[idx] == null) {
            table[idx] = new Node<>(value);
            size++;
        } else {
            Node<T> cur = table[idx];
            int cnt = 0;
            while (cur != null) {
                cnt++;
                if (cur.value.equals(value)) return;
                if (cur.next == null) {
                    cur.next = new Node<>(value);
                    cur.next.prev = cur;
                    size++;
                    return;
                }
                cur = cur.next;
                maxDepth = max(cnt, maxDepth);
            }
        }
    }

    public void remove(T value){
        int idx = hash(value);
        if (table[idx] != null) {
            Node<T> cur = table[idx];
            while (cur != null) {
                if (cur.value.equals(value)) {
                    //TODO
                    if (cur.next == null) {
                        cur.prev.next = null;
                        cur = null;
                    } else {
                        //оптим ален ли этот метод? или есть лучше? какие?
                        Node<T> prevNode = cur.prev, nextNode = cur.next;
                        prevNode.next.prev = null;
                        prevNode.next = null;
                        nextNode.prev.next = null;
                        nextNode.prev = null;
                        nextNode.prev = prevNode;
                        prevNode.next = nextNode;
                    }
                    size--;
                    break;
                }
                cur = cur.next;
            }
        }
    }

    public boolean contains(T value){
        int idx = hash(value);
        if (table[idx] == null) {
            return false;
        }
        else {
            Node<T> cur = table[idx];
            while (cur != null) {
                if (cur.value.equals(value)) return true;
                cur = cur.next;
            }
        }
        return false;
    }

    //можно использовать хеш объекта
    private int hash(T value){
        return (value.hashCode()) % capacity;
    }

    //0.2
    private double quality(){
        return (double)maxDepth / table.length;
    }

    private void rehash(){
        if(quality() > 0.2) {
            //TODO
            ArrayList<T> list = new ArrayList<>();
            for (int i = 0; i < capacity; i++) {
                if (table[i] != null) {
                    Node<T> cur = table[i];
                    while (cur != null) {
                        list.add(cur.value);
                        cur = cur.next;
                        cur.prev = null;
                    }
                }
            }
            capacity = genNextPrime(2 * capacity);
            table = (Node<T>[]) new Object[capacity];
            for (T el : list) {
                add(el);
            }
        }
    }

    private int genNextPrime(int n){
        //TODO
        //убрал из поиска четные числа, что вызывает уменьшение операций вдвое
        //есть ли способы еще ускорить алгоритм? какой способ получения
        //следующего простого числа самый оптимальный?
        if (n % 2 == 0) {
            n += 1;
            while (!isPrime(n)) {
                n +=2;
            }
        } else {
            n +=2;
            while (!isPrime(n)) {
                n +=2;
            }
        }
        return n;
    }

    //проверяет простое число или нет
    //простое - это число которое делится
    //только на себя или на 1
    private boolean isPrime(int n){
        //TODO
        //убрал из поиска четные числа и большие чем корень из n
        //есть ли способы еще ускорить алгоритм? какие?
        //какой способ получения простого числа самый оптимальный?
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        int tmp = (int)Math.sqrt(n);
        for (int i = 3; i <= tmp; i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

package main.java;

import java.util.*;

public class Graph {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(friendCounter(in));

        /*
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        ArrayList<Vertex> vertices = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<>());
            vertices.add(new Vertex(i));
        }

        for (int i = 0; i < 5; i++) {
            int from = in.nextInt(), to = in.nextInt();
            graph.get(from).add(vertices.get(to));
            graph.get(to).add(vertices.get(from));
        }

        System.out.println(dfs(graph, graph.get(3).get(0), new ArrayList<Vertex>()).size());
         */
    }

    static int[] dis = new int[8];

    //метод обход графа в глубину
    private static void dfs(ArrayList<ArrayList<Vertex>> graph, Vertex v) {
        if (!v.visit) {
            v.visit = true;
            System.out.print(v + " ");
            for (Vertex vertex : graph.get(v.number)) {
                dfs(graph, vertex);
            }
        }
    }

    //метод обхода графа в глубину с выдачей списка всех связанных вершин с данной вершиной
    private static ArrayList<Vertex> dfs(ArrayList<ArrayList<Vertex>> graph, Vertex v, ArrayList<Vertex> list) {
        if (!v.visit) {
            v.visit = true;
            list.add(v);
            for (Vertex vertex : graph.get(v.number)) {
                dfs(graph, vertex, list);
            }
        }
        return list;
    }

    //метод последовательного обхода графа
    private static void bfs(ArrayList<ArrayList<Vertex>> graph, Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        v.visit = true;
        queue.push(v);
        while (!queue.isEmpty()) {
            Vertex tmp = queue.pollFirst();
            if (!tmp.visit) System.out.print(tmp + " ");
            if (!tmp.visit) {
                tmp.visit = true;
                for (Vertex vertex : graph.get(tmp.number)) {
                    queue.push(vertex);
                    if (!vertex.visit) {
                        dis[vertex.number] = Math.min(dis[tmp.number] + 1, dis[vertex.number]);
                    }
                }
            }
        }
    }

    //Функция должна вернуть количество знакомых у самого популярного человека
    //знакомые это друзья и друзья друзей в глубину до бесконечности)))
    //самый популярный человек - это человек у которого больше всего знакомых
    static int friendCounter(Scanner in){
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        ArrayList<Vertex> vertices = new ArrayList<>();

        System.out.println("Введите количество людей");
        int n = in.nextInt(); // количество людей
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            vertices.add(new Vertex(i));
        }

        System.out.println("Введите количество пар связей");
        int m = in.nextInt();//количество пар связей

        System.out.println("Введите связи: номер первого человека и через пробел номер второго человека");
        //далее следуют м пар значений
        for (int i = 0; i < m; i++) {
            int from = in.nextInt(), to = in.nextInt();
            graph.get(from).add(vertices.get(to));
            graph.get(to).add(vertices.get(from));
        }

        int maxNumberFriends = 0;

        for (int i = 0; i < n; i++) {
            //получаем список друзей каждого человека, от его длины нужно отнять 1 (т.к. его самого не учитываем)
            int tmp = dfs(graph, graph.get(i).get(0), new ArrayList<Vertex>()).size() - 1;
            if (tmp > maxNumberFriends) {
                maxNumberFriends = tmp;
            }
        }
        //при необходимости, вместа количества друзей, можно вернуть номер человека или список его друзей
        return maxNumberFriends;
    }

    static int travelingSalesman(Scanner in){
        int n = in.nextInt();
        int [][] m = new int[n][n];//matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        //TODO
        return 0;
    }

    //вернуть путь с минимальным вторым городом
    //путь должен состоять из n чисел
    static int [] travelingSalesmanWay(Scanner in){
            int n = in.nextInt();
            int [][] m = new int[n][n];//matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    m[i][j] = in.nextInt();
                }
            }
        //TODO
        return null;
    }
}

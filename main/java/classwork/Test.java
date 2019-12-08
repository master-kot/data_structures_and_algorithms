package main.java.classwork;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        //list of links
        //список смежности
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        ArrayList<Vertex> vertices = new ArrayList<>();

        int n = 7;
        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<>());
            vertices.add(new Vertex(i));
        }
        Scanner in = new Scanner(System.in);
        //1 2, 2 5, 1 3, 4 6, 6 7
        HashSet<Vertex> set = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            int from = in.nextInt(), to = in.nextInt();
            graph.get(from).add(vertices.get(to));
            graph.get(to).add(vertices.get(from));
        }
        for (int i = 0; i < 8; i++) {
            dis[i] = 10000;
        }
        dis[1] = 0;
        bfs(graph, vertices.get(1));
        System.out.println(Arrays.toString(dis));
    }

    static int [] dis = new int[8];

    //обход графа в глубину
    private static void dfs(ArrayList<ArrayList<Vertex>> graph, Vertex v) {
        if (!v.visit) {
            v.visit = true;
            System.out.print(v + " ");
            for (Vertex vertex : graph.get(v.number)) {
                dfs(graph, vertex);
            }
        }
    }

    private static void bfs(ArrayList<ArrayList<Vertex>> graph, Vertex v) {
        LinkedList<Vertex> queue = new LinkedList<>();
        //v.visit = true;
        queue.push(v);
        while (!queue.isEmpty()) {
            Vertex tmp = queue.pollFirst();
            if(!tmp.visit) System.out.print(tmp + " ");
            if (!tmp.visit) {
                tmp.visit = true;
                for (Vertex vertex : graph.get(tmp.number)) {
                    queue.push(vertex);
                    if(!vertex.visit){
                        dis[vertex.number] = Math.min(dis[tmp.number] + 1, dis[vertex.number]);
                    }
                }
            }
        }
    }

}

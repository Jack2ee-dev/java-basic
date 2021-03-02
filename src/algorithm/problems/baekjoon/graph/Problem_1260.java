package algorithm.problems.baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1260 {

    private static boolean[][] graph;
    private static boolean[] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertex = in.nextInt();
        int node = in.nextInt();
        int start = in.nextInt();
        graph = new boolean[vertex + 1][vertex + 1];
        for (int i = 0; i < node; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        visit = new boolean[vertex + 1];
        dfs(start);
        System.out.println();
        bfs(start);
    }

    private static void bfs(int start) {
        visit = new boolean[graph.length];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        visit[start] = true;
        System.out.print(start + " ");
        while (!qu.isEmpty()) {
            int polled = qu.poll();
            for (int i = 1; i < graph[polled].length; i++) {
                if (!visit[i] && graph[polled][i]) {
                    System.out.print(i + " ");
                    qu.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        System.out.print(start+ " ");
        visit[start] = true;
        for (int i = 1; i < graph.length; i++) {
            if (!visit[i] && graph[start][i]) {
                visit[i] = true;
                dfs(i);
            }
        }
    }
}

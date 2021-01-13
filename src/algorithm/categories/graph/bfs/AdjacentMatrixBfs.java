package algorithm.categories.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacentMatrixBfs {

    static int[][] adjMatrix;
    static boolean[] visited;
    static int Ne; // number of edges
    static int Nv; // number of vertices

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Nv = scan.nextInt();
        Ne = scan.nextInt();
        adjMatrix = new int[Nv + 1][Nv + 1];
        visited = new boolean[Nv + 1];

        for (int i = 0; i < Ne; i++) {
            int t1, t2;
            t1 = scan.nextInt();
            t2 = scan.nextInt();

            adjMatrix[t1][t2] = adjMatrix[t2][t1] = 1;
        }

        adjListBfs(1);
    }

    static void adjListBfs(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.println(u);

            for (int i = 1; i <= Nv; i++) {
                boolean isAdjacent = adjMatrix[u][i] == 1;
                if (isAdjacent && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
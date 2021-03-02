package algorithm.problems.baekjoon.graph;

import java.util.Scanner;

public class Problem_2606 {

    private static boolean[][] network;
    private static boolean[] visit;
    private static int virus = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        network = new boolean[N][N];
        visit = new boolean[N];
        for (int i = 0; i < M; i++) {
            int com1 = in.nextInt() - 1;
            int com2 = in.nextInt() - 1;
            network[com1][com2] = true;
            network[com2][com1] = true;
        }

        dfs(0);
        System.out.println(virus);
    }

    private static void dfs(int com) {
        visit[com] = true;
        for (int i = 0; i < network[com].length; i++) {
            if (!visit[i] && network[com][i]) {
                virus++;
                dfs(i);
            }
        }
    }
}

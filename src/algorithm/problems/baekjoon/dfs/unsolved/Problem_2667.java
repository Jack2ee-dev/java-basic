package algorithm.problems.baekjoon.dfs.unsolved;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem_2667 {

    private static int[][] map;
    private static boolean[][] visit;
    private static final PriorityQueue<Integer> complex = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            dfs(i);
        }
    }

    private static void dfs(int row) {
    }
}

package algorithm.problems.baekjoon.recursion;

import java.util.Scanner;

public class Problem_6603 {

    private static int N;
    private static int[] NUMBERS;
    private static boolean[] VISITED;
    private static int FULL = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                break;
            }
            NUMBERS = new int[N];
            VISITED = new boolean[N];
            for (int i = 0; i < N; i++) {
                NUMBERS[i] = sc.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == FULL) {
            for (int i = 0; i < N; i++) {
                if (VISITED[i]) {
                    System.out.print(NUMBERS[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < N; i++) {
            VISITED[i] = true;
            dfs(i + 1, depth + 1);
            VISITED[i] = false;
        }
    }
}

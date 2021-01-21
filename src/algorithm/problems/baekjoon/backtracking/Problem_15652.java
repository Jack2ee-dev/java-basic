package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_15652 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        arr = new int[M];

        dfs(1, 0);
    }

    private static void dfs(int number, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = number; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}

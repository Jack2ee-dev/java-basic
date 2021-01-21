package algorithm.problems.baekjoon.backtracking.unsolved;

import java.util.Scanner;

public class Problem_15651 {

    private static int[] arr;
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

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

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

}

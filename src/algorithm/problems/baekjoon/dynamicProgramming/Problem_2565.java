package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem_2565 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] overall = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            overall[i][0] = in.nextInt();
            overall[i][1] = in.nextInt();
        }

        Arrays.sort(overall, Comparator.comparingInt(o -> o[0]));

        int[] B = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            B[i] = overall[i][1];
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (B[i] > B[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(N - max);
    }

}

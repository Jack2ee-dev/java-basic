package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_2156 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] wines = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            wines[i] = in.nextInt();
        }

        System.out.println(Arrays.toString(wines));

        int[] dp = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            dp[i] = Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        int max = 0;
        for (int i = 3; i < N + 3; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);

    }
}

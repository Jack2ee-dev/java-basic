package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Scanner;

public class Problem_1904 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < N + 1; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(dp[N] % 15746);
    }
}

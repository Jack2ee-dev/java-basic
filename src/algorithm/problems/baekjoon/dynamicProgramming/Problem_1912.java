package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1912 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
        }

        Arrays.sort(dp);
        System.out.println(dp[N - 1]);
    }
}

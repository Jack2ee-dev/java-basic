package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem_11054 {

    private static int[] arr;
    private static int[] dpLR;
    private static int[] dpRL;
    private static int N;

    public static void main(String[] args) {
        get();
        System.out.println(solve());
    }

    static void get() {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        arr = new int[N + 1];
        dpLR = new int[N + 1];
        dpRL = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = in.nextInt();
        }
    }

    static int solve() {
        for (int i = 1; i <= N; i++) {
            dpLR[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpLR[i] = Math.max(dpLR[j] + 1, dpLR[i]);
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            dpRL[i] = 1;
            for (int j = N; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dpRL[i] = Math.max(dpRL[j] + 1, dpRL[i]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (dpLR[i] + dpRL[i] > max) {
                max = dpLR[i] + dpRL[i];
            }
        }

        return max - 1;
    }

}

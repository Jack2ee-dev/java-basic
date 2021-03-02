package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1932 {

    private static int[][] arr;

    public static void main(String[] args) {
        get();
        System.out.println(calculate());
    }

    static void get() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = in.nextInt();
            }
        }
    }

    static int calculate() {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] += arr[i-1][j];
                }
                else if (j == i) {
                    arr[i][j] += arr[i-1][j-1];
                }
                else {
                    arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
                }
            }
        }

        int[] can = arr[arr.length - 1];
        Arrays.sort(can);
        return can[can.length - 1];
    }
}

package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Scanner;

public class Problem_1463 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[1000001];
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }
        System.out.println(arr[N]);
    }
}

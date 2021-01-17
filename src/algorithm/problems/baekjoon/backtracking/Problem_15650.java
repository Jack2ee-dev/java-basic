package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_15650 {
    
    private static int[] arr;
    private static int N;
    private static int M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];
        dfs(0, 1);
    }
    
    private static void dfs(int depth, int at) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}

package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_15649 {
    
    private static int[] arr;
    private static boolean[] visit;
    private static int N, M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }
    
    private static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}

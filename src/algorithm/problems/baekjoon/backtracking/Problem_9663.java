package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_9663 {
    
    private static int[] arr;
    private static int N;
    private static int count = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        
        nQueen(0);
        System.out.println(count);
    }
    
    private static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possible(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    
    private static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
        }
        
        for (int i = 0; i < col; i++) {
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        
        return true;
    }
}

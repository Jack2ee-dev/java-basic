package algorithm.problems.baekjoon.greedy;

import java.util.Scanner;

public class Problem_11047 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            cnt += K / a[i];
            K %= a[i];
        }
        System.out.println(cnt);
        sc.close();
    }
}

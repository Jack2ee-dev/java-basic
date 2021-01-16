package algorithm.problems.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_2217 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] ropes = new Integer[N];
        for (int i = 0; i < N; i++) {
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes);
        
        int maxWeight = 0;
        for (int i = 0; i < ropes.length; i++) {
            maxWeight = Math.max(maxWeight, ropes[i] * (ropes.length - i));
        }
        System.out.println(maxWeight);
    }
}

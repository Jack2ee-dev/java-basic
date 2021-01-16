package algorithm.problems.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_5585 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] errands = {1, 5, 10, 50, 100, 500};
        Arrays.sort(errands);
        int p = 1000 - sc.nextInt();
        
        int answer = 0;
        for (int i = errands.length - 1; i >= 0; i--) {
            answer += p / errands[i];
            p %= errands[i];
        }
        System.out.println(answer);
    }
}

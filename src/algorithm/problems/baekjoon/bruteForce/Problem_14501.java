package algorithm.problems.baekjoon.bruteForce;

import java.util.Scanner;

public class Problem_14501 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] T = new int[N];
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            String[] inputs = sc.nextLine().split(" ");
            T[i] = Integer.parseInt(inputs[0]);
            P[i] = Integer.parseInt(inputs[1]);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int curIdx = i;
            int tmp = 0;
            while (curIdx + 1 + T[curIdx] <= N) {
                tmp += P[curIdx];
                curIdx += T[curIdx];
            }
            answer = Math.max(answer, tmp);
        }
        
        System.out.println(answer);
    }
}
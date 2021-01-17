package algorithm.problems.baekjoon.greedy.unsolved;

import java.util.Scanner;

public class Problem_4796 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int cnt = 1;
        while (true) {
            String[] inputs = sc.nextLine().split(" ");
            int L = Integer.parseInt(inputs[0]);
            int P = Integer.parseInt(inputs[1]);
            int V = Integer.parseInt(inputs[2]);
            if (L == 0 && P == 0 && V == 0) {
                return;
            }
            
            int answer = (V/P)*L + (V%P);
            System.out.println("Case " + cnt++ + ": " + answer);
        }

        
    }
}

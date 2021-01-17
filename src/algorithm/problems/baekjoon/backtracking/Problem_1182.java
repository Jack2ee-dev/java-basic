package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_1182 {
    
    private static int N, S;
    private static int[] numbers;
    private static int answer = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] inputs = sc.nextLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        S = Integer.parseInt(inputs[1]);
        numbers = new int[N];
        
        String[] numberInput = sc.nextLine().split(" ");
        for (int i = 0; i < numberInput.length; i++) {
            numbers[i] = Integer.parseInt(numberInput[i]);
        }
        
        dfs(0, 0);
        System.out.println(answer);
    }
    
    private static void dfs(int idx, int sum) {
        if (sum == S) {
            answer++;
        }
        
        if (idx == N) {
            return;
        }
        
        dfs(idx + 1, sum + numbers[idx]);
        dfs(idx + 1, sum);
    }
}

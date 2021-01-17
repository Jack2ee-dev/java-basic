package algorithm.problems.baekjoon.backtracking;

import java.util.Scanner;

public class Problem_14888 {
    
    private static int[] arr;
    private static int N;
    private static int[] operations = new int[4];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        
        String[] numbers = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        
        String[] ops = sc.nextLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operations[i] = Integer.parseInt(ops[i]);
        }
        
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void dfs(int numIdx, int result) {
        if (numIdx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                
                switch (i) {
                    case 0:
                        dfs(numIdx + 1, result + arr[numIdx]);
                        break;
                    case 1:
                        dfs(numIdx + 1, result - arr[numIdx]);
                        break;
                    case 2:
                        dfs(numIdx + 1, result * arr[numIdx]);
                        break;
                    case 3:
                        dfs(numIdx + 1, result / arr[numIdx]);
                        break;
                    default:
                }
                operations[i]++;
            }
            
        }
    }
}

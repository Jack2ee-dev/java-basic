package algorithm.problems.baekjoon.backtracking.unsolved;

import java.util.Scanner;

public class Problem_14889 {
    
    private static int[][] capacity;
    private static boolean[] select;
    private static int N;
    private static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        capacity = new int[N][N];
        select = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                capacity[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }
    
    private static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            diff();
            return;
        }
        
        for (int i = idx; i < N; i++) {
            if (!select[i]) {
                select[i] = true;
                dfs(depth + 1, idx + 1);
                select[i] = false;
            }
        }
    }
    
    private static void diff() {
        int team_start = 0;
        int team_link = 0;
    
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (select[i] && select[j]) {
                    team_start += capacity[i][j];
                    team_start += capacity[j][i];
                }
                else if (!select[i] && !select[j]) {
                    team_link += capacity[i][j];
                    team_link += capacity[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        
        min = Math.min(val, min);
    }
}

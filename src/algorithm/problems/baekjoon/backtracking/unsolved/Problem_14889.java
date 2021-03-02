package algorithm.problems.baekjoon.backtracking.unsolved;

import java.util.Scanner;

public class Problem_14889 {

    private static int[][] capa;
    private static int playerPerTeam;
    private static int N;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        playerPerTeam = N / 2;
        capa = new int[N][N];
        visit = new boolean[N];
        spread(in);
        dfs(0);
        System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == playerPerTeam) {
            diff();
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int temp = 0;
        for (int i = 0; i < visit.length - 1; i++) {
            for (int j = i + 1; j < visit.length; j++) {
                if (visit[i] && visit[j]) {
                    temp += capa[i][j] + capa[j][i];
                } else if (!visit[i] && !visit[j]) {
                    temp -= capa[i][j] + capa[j][i];
                }
            }
        }
        min = Math.min(min, Math.abs(temp));
    }

    private static void spread(Scanner in) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                capa[i][j] = in.nextInt();
            }
        }
    }
}

package algorithm.problems.programmers.catetories.dynamicProgramming.requiredRepetition.nExpression.roadToSchool;

public class Main {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        Solution s = new Solution();
        System.out.println(s.solution(m, n, puddles));
    }

}

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] weights = new int[n][m];
        for (int i = 1; i < m; i++) {
            weights[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            weights[i][0] = 1;
        }
        for (int[] puddle : puddles) {
            int row = puddle[1] - 1;
            int column = puddle[0] - 1;
            if (row == 0) {
                for (int i = 0; i < m; i++) {
                    weights[row][i] = -1;
                }
            }
            if (column == 0) {
                for (int i = 0; i < n; i++) {
                    weights[i][column] = -1;
                }
            }
            weights[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (weights[i][j] != -1) {
                    if (i > 0 && j > 0) {
                        weights[i][j] = weights[i - 1][j] + weights[i][j - 1];
                    }
                } else {
                    weights[i][j] = 0;
                }
            }
        }

        return weights[n - 1][m - 1] % 1000000007;
    }
}
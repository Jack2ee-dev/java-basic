package algorithm.problems.programmers.catetories.greedy.connectIslands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectIslands {

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {
            {0, 1, 1},
            {0, 2, 2},
            {1, 2, 5},
            {1, 3, 1},
            {2, 3, 8}
        };
        Solution s = new Solution();
        System.out.println(s.solution(n ,costs));
    }
}

class Solution {
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[costs[i][0]][costs[i][1]] = costs[i][2];
            matrix[costs[i][1]][costs[i][0]] = costs[i][2];
        }
    
        System.out.println(Arrays.deepToString(matrix));
        return answer;
    }
    
    int dfs(int[][] matrix, int[] visited, int depth, int min) {
        if (depth == matrix.length) {
            return min;
        }
        
        return 1;
    }
}
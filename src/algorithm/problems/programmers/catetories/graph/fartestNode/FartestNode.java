package algorithm.problems.programmers.catetories.graph.fartestNode;

import java.util.LinkedList;
import java.util.Queue;

public class FartestNode {
    
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        Solution s = new Solution();
        System.out.println(s.solution(n, vertex));
    }
    
}

class Solution {
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < edge.length; i++) {
            matrix[edge[i][0] - 1][edge[i][1] - 1] = true;
            matrix[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);
        
        int[] dist = new int[n];
        int maxDist = 0;
        while (!qu.isEmpty()) {
            int polledIdx = qu.poll();
            for (int i = 1; i < n; i++) {
                if (matrix[polledIdx][i] && dist[i] == 0) {
                    qu.offer(i);
                    dist[i] += dist[polledIdx] + 1;
                    maxDist = Math.max(maxDist, dist[i]);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        
        return answer;
    }
}
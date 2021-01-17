package algorithm.problems.programmers.catetories.graph.Ranking;

public class Ranking {
    
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        Solution s = new Solution();
        System.out.println(s.solution(n, results));
    }
}

class Solution {
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[results[i][0] - 1][results[i][1] - 1] = 1;
            map[results[i][1] - 1][results[i][0] - 1] = -1;
        }
        
        return answer;
    }
}
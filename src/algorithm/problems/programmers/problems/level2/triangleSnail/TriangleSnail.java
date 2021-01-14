package algorithm.problems.programmers.problems.level2.triangleSnail;

import java.util.Arrays;

public class TriangleSnail {

    public static void main(String[] args) {
        int n = 6;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n)));
    }
}

class Solution {
    private static int MOVE_UP = -1;
    private static int MOVE_DOWN = 0;
    private static int MOVE_RIGHT = 1;
    
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int end = (n+1) * n / 2;
        int direction = MOVE_DOWN;
        
        int currentNum = 1;
        int i = 0; // row
        int j = 0; // column
        while (currentNum < end) {
            matrix[i][j] = currentNum++;
            
        }
        
        
        return matrix[0];
    }
}
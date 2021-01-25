package algorithm.problems.programmers.problems.level2.muliplyMatrix;

import java.util.Arrays;

public class MultiplyMatrix {

    public static void main(String[] args) {
        int[][] arr1 = {
            {2, 3, 2},
            {4, 2, 4},
            {3, 1, 4}
        };
        int[][] arr2 = {
            {5, 4, 3},
            {2, 4, 1},
            {3, 1, 1},
        };
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.solution(arr1, arr2)));
    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < arr1[0].length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
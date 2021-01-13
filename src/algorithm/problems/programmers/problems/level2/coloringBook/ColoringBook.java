package algorithm.problems.programmers.problems.level2.coloringBook;

import java.util.Arrays;

public class ColoringBook {

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] pictures = {
            {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(m, n, pictures)));
    }
}

class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = {};
        return answer;
    }
}

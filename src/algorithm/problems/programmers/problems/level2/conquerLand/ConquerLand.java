package algorithm.problems.programmers.problems.level2.conquerLand;

import java.util.Arrays;

public class ConquerLand {

    public static void main(String[] args) {
        int[][] land = {
            {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
        };
        Solution s = new Solution();
        System.out.println(s.solution(land));
    }
}

class Solution {

    int solution(int[][] land) {
        return 1;
    }
}
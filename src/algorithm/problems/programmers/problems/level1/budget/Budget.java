package algorithm.problems.programmers.problems.level1.budget;

import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {
        int[] d = {2, 2, 3, 3};
        int budget = 10;
        Solution s = new Solution();
        System.out.println(s.solution(d, budget));
    }
}

class Solution {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int total = 0;
        int cnt = 0;
        for (int i = 0; i < d.length; i++) {
            if (total + d[i] > budget) {
                break;
            }
            total += d[i];
            cnt++;
        }

        return cnt;
    }
}

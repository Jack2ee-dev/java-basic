package algorithm.problems.programmers.problems.level1.reverseNumber;

import java.util.Arrays;

public class ReverseNumber {

    public static void main(String[] args) {
        long n = 118372;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(n)));
    }
}

class Solution {

    public int[] solution(long n) {
        String stringified = Long.toString(n);
        int[] answer = new int[stringified.length()];
        String[] split = stringified.split("");

        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.parseInt(split[stringified.length() - i - 1]);
            answer[stringified.length() - i - 1] = Integer.parseInt(split[i]);
        }

        return answer;
    }
}

package algorithm.problems.programmers.problems.level2.compressString;

import java.util.ArrayList;
import java.util.List;

public class CompressString {

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public int solution(String s) {
        int answer = 0;
        List<Integer[]> split = new ArrayList<>();
        for (int i = 2; i < s.length() / 2; i++) {

        }

        return answer;
    }
}
package algorithm.problems.programmers.problems.level1.sortArbitrarily;

import java.util.Arrays;

public class SortArbitrarily {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(strings, n)));
    }
}

class Solution {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            char c1 = o1.charAt(n);
            char c2 = o2.charAt(n);

            if (c1 == c2) {
                return o1.compareTo(o2);
            } else {
                return c1 - c2;
            }
        });
        return strings;
    }
}



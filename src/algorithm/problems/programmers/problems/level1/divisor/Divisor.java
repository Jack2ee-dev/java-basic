package algorithm.problems.programmers.problems.level1.divisor;

import java.util.ArrayList;
import java.util.List;

public class Divisor {

    public static void main(String[] args) {
        int n = 12;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    public int solution(int n) {
        int answer = 0;
        int sqrt = (int) Math.sqrt(n);
        List<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                divisor.add(i);
                if (i != n / i) {
                    divisor.add(n / i);
                }
            }
        }

        for (Integer integer : divisor) {
            answer += integer;
        }
        return answer;
    }
}
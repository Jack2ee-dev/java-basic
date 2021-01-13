package algorithm.problems.programmers.problems.level1.gcdLcm;

import java.util.Arrays;

public class GCDLCM {

    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n, m)));
    }
}

class Solution {

    public int[] solution(int n, int m) {
        int cGcd = gcd(n, m);
        int cLcm = cGcd * (n / cGcd) * (m / cGcd);
        int[] answer = new int[]{cGcd, cLcm};
        return answer;
    }

    private int gcd(int a, int b) {
        int max;
        int min;
        if (a > b) {
            max = a;
            min = b;
        } else if (a < b) {
            max = b;
            min = a;
        } else {
            max = min = a;
        }

        if (min == 0) {
            return max;
        }
        return gcd(min, max % min);
    }
}

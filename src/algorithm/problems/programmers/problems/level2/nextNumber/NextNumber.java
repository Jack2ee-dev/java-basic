package algorithm.problems.programmers.problems.level2.nextNumber;

import java.util.Arrays;

public class NextNumber {

    public static void main(String[] args) {
        int n = 78;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    private int number;
    private boolean[] visit;

    public int solution(int n) {
        int cntOneN = cntOne(n);

        int nextNum = n + 1;
        while (true) {
            if (cntOne(nextNum) != cntOneN) {
                nextNum++;
            } else {
                break;
            }
        }


        return nextNum;
    }

    private int cntOne(int n) {
        String binary = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}

package algorithm.problems.programmers.problems.level1.sumBetweenTwoNumber;

public class SumBetweenTwoNumber {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        Solution s = new Solution();
        System.out.println(s.solution(a, b));
    }
}

class Solution {

    public long solution(int a, int b) {
        long answer = 0;
        if (a == b) {
            return a;
        }

        if (a < b) {
            for (int i = a; i < b + 1; i++) {
                answer += i;
            }
        } else {
            for (int i = b; i < a + 1; i++) {
                answer += i;
            }
        }
        return answer;
    }
}
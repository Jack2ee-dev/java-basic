package algorithm.problems.programmers.problems.level2.numberExpression;

public class NumberExpression {

    public static void main(String[] args) {
        int n = 15;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }

}

class Solution {

    public int solution(int n) {
        int answer = 1;

        int start = 1;
        while (start < n / 2 + 1) {
            int sum = 0;
            for (int i = start; i <= n / 2 + 1; i++) {
                sum += i;
                System.out.print(i);
                if (sum > 15) {
                    break;
                } else if (sum == 15) {
                    answer++;
                    break;
                }
            }
            start++;
        }

        return answer;
    }
}
package algorithm.problems.programmers.problems.level2.country124;

public class Country124 {

    public static void main(String[] args) {
        int n = 14;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    public String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String answer = "";

        int num = n;

        while (num > 0) {
            int remainder = num % 3;
            num /= 3;

            if (remainder == 0) {
                num--;
            }

            answer = numbers[remainder] + answer;
        }

        return answer;
    }
}
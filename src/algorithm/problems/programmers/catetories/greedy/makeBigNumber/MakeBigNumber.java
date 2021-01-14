package algorithm.problems.programmers.catetories.greedy.makeBigNumber;

public class MakeBigNumber {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        Solution s = new Solution();
        System.out.println(s.solution(number, k));
    }
}

class Solution {
    public String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < number.length() - k; i++) {
            max = '0';
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}
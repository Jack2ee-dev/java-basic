package algorithm.problems.programmers.problems.level1.getMiddleString;

public class GetMiddleString {

    public static void main(String[] args) {
        String s = "qwer";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 != 0) {
            answer += s.charAt(s.length() / 2);
        } else {
            answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        }
        return answer;
    }
}
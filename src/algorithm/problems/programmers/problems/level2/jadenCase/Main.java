package algorithm.problems.programmers.problems.level2.jadenCase;

public class Main {

    public static void main(String[] args) {
        String s = "3people  unFollowed me";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        answer.append((s.charAt(0) + "").toUpperCase());
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(" ");
            } else if (s.charAt(i - 1) == ' ') {
                answer.append((s.charAt(i) + "").toUpperCase());
            } else {
                answer.append((s.charAt(i) + "").toLowerCase());
            }
        }
        return answer.toString();
    }
}
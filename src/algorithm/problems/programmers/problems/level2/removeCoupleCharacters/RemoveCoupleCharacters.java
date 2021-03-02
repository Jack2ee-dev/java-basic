package algorithm.problems.programmers.problems.level2.removeCoupleCharacters;

import java.util.Stack;

public class RemoveCoupleCharacters {

    public static void main(String[] args) {
        String s = "baabaa";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0 || stack.peek() != s.charAt(i)) {
                stack.add(s.charAt(i));
            } else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            }
        }
        if (stack.size() == 0) {
            answer = 1;
        }
        return answer;
    }
}
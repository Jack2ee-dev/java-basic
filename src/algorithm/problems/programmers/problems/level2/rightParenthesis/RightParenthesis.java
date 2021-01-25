package algorithm.problems.programmers.problems.level2.rightParenthesis;

import java.util.Stack;

public class RightParenthesis {

    public static void main(String[] args) {
        String s = "(()(";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    boolean solution(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                check++;
            } else {
                if (check <= 0) {
                    return false;
                } else {
                    check--;
                }
            }
        }


        return check == 0;
    }
}
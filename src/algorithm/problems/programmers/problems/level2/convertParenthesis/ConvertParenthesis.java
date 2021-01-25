package algorithm.problems.programmers.problems.level2.convertParenthesis;

import java.util.Arrays;
import java.util.Stack;

public class ConvertParenthesis {

    public static void main(String[] args) {
        String p = "()))((()";
        Solution s = new Solution();
        System.out.println(s.solution(p));
    }

}

class Solution {

    public String solution(String p) {
        String answer = "";
        if (p.length() == 0) {
            return p;
        }

        StringBuilder right = new StringBuilder();


        return answer;
    }

    private String[] split(String s) {
        String u = "";
        String v = "";
        for (int i = 2; i < s.length(); i += 2) {
            if (right(s.substring(0, i))) {
                u = s.substring(0, i);
                v = s.substring(i);
            }
        }

        return new String[]{u, v};
    }

    private boolean right(String p) {
        Stack<String> st = new Stack<>();
        String[] split = p.split("");
        int cnt = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) {
                st.push(split[i]);
            } else {
                if (st.isEmpty()) {
                    break;
                } else {
                    st.pop();
                    cnt++;
                }
            }
        }

        return cnt == split.length / 2;
    }
}
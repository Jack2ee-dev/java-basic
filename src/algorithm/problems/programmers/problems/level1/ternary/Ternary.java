package algorithm.problems.programmers.problems.level1.ternary;

import java.util.Stack;

public class Ternary {

    public static void main(String[] args) {
        int n = 45;
        Solution s = new Solution();
        System.out.println(s.solution(45));
    }
}

class Solution {

    public int solution(int n) {
        int answer = 0;
        int TERNARY = 3;
        Stack<Integer> st = new Stack<>();

        while (n != 0) {
            st.add(n % TERNARY);
            n /= TERNARY;
        }

        int pow = 0;
        while (!st.isEmpty()) {
            answer += st.pop() * Math.pow(TERNARY, pow++);
        }

        return answer;
    }
}

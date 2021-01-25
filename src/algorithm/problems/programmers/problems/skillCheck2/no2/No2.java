package algorithm.problems.programmers.problems.skillCheck2.no2;

import java.util.PriorityQueue;

public class No2 {

    public static void main(String[] args) {
        String s = "-1 -1";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for (String str : split) {
            qu.offer(Integer.parseInt(str));
        }

        int index = 0;
        StringBuilder answer = new StringBuilder();
        while (!qu.isEmpty()) {
            String polled = Integer.toString(qu.poll());
            if (index == 0) {
                answer.append(polled).append(" ");
            } else if (index == split.length - 1) {
                answer.append(polled);
            }
            index++;
        }
        return answer.toString();
    }
}
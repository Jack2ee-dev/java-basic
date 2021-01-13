package algorithm.problems.programmers.problems.level2.printer;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        Solution s = new Solution();
        System.out.println(s.solution(priorities, location));
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.offer(p);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    answer++;
                }
                if (location == i) {
                    pq.clear();
                    break;
                }
            }
        }
        
        return answer;
    }
}

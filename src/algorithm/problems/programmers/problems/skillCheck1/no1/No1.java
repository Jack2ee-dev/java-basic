package algorithm.problems.programmers.problems.skillCheck1.no1;

import java.util.PriorityQueue;

public class No1 {

    public static void main(String[] args) {
        int[] scoville = {
            1, 1, 1
        };
        int K = 7;
        Solution s = new Solution();
        System.out.println(s.solution(scoville, K));
    }
}

class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for (int s : scoville) {
            qu.offer(s);
        }

        int answer = 0;
        boolean possible = false;
        while (qu.size() > 1) {
            int s1 = qu.poll();
            int s2 = qu.poll();
            int mixed = s1 + s2 * 2;
            qu.offer(mixed);
            answer++;
            if (qu.peek() >= K) {
                possible = true;
                break;
            }
        }

        if (!possible) {
            return -1;
        }

        return answer;
    }
}
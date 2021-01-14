package algorithm.problems.programmers.catetories.heap.moreSpicy;

import java.util.PriorityQueue;

public class MoreSpicy {
    
    public static void main(String[] args) {
        int[] scoville = {
            1, 2
        };
        int K = 7;
        Solution s = new Solution();
        System.out.println(s.solution(scoville, K));
    }
}

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pqu = new PriorityQueue<>();
        for (int i : scoville) {
            pqu.offer(i);
        }
        
        while (true) {
            if (pqu.size() > 1 && pqu.peek() < K) {
                pqu.offer(pqu.poll() + pqu.poll() * 2);
                answer++;
            } else {
                if (pqu.size() <= 1 && pqu.peek() < K) {
                    answer = -1;
                }
                break;
            }
        }
        
        return answer;
    }
}

package algorithm.problems.codility;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        int[] A = {-1, -3};
        Solution s = new Solution();
        System.out.println(s.solution(A));
    }
}

class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            qu.offer(A[i]);
        }

        int min = 1;
        while (!qu.isEmpty()) {
            int p = qu.poll();
            if (min == p) {
                min++;
            } else if (min < p) {
                break;
            }
        }

        return min;
    }
}
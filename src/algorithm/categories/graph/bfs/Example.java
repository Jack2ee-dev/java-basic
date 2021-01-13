/*
programmers>깊이/너비 우선탐색>타겟 넘버
https://programmers.co.kr/learn/courses/30/lessons/43165
 */

package algorithm.categories.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Example {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Solution s = new Solution();
        System.out.println(s.solution(numbers, target));
    }
}

class Solution {

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(numbers[0], 0));
        q.offer(new Pair(-numbers[0], 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.index == numbers.length - 1) {
                if (p.currentSum == target) {
                    answer++;
                }
                continue;
            }

            int c1 = p.currentSum + numbers[p.index + 1];
            int c2 = p.currentSum - numbers[p.index + 1];
            q.offer(new Pair(c1, p.index + 1));
            q.offer(new Pair(c2, p.index + 1));
        }

        return answer;
    }
}

class Pair {

    int currentSum;
    int index;

    public Pair(int currentSum, int index) {
        this.currentSum = currentSum;
        this.index = index;
    }
}
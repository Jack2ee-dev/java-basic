package algorithm.problems.programmers.catetories.stackQueue.truck;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }
}

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weightOnBridge = 0;
        Queue<Integer> passing = new LinkedList<>();
        Queue<Integer> waiting = new LinkedList<>();
        for (int w : truck_weights) {
            waiting.offer(w);
        }

        while (!waiting.isEmpty()) {
            if (passing.isEmpty()) {
                int w = waiting.poll();
                passing.offer(w);
                answer++;
                weightOnBridge += w;
            } else if (passing.size() == bridge_length) {
                int w = passing.poll();
                weightOnBridge -= w;
            } else {
                if (weightOnBridge + waiting.peek() <= weight) {
                    int w = waiting.poll();
                    passing.offer(w);
                    answer++;
                    weightOnBridge += w;
                } else {
                    passing.offer(0);
                    answer++;
                }
            }
        }

        return answer + bridge_length;
    }
}
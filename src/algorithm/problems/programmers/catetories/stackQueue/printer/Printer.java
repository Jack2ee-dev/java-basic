package algorithm.problems.programmers.catetories.stackQueue.printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {
        int[] priorities = {4, 10, 200, 5};
        int location = 0;
        Solution s = new Solution();
        System.out.println(s.solution(priorities, location));
    }
}

class Solution {

    public int solution(int[] priorities, int location) {
        int length = priorities.length;
        List<Integer> idxPrinted = new ArrayList<>();
        Queue<Integer> idxWaiting = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            boolean printed = true;
            for (int j = i + 1; j < length; j++) {
                if (priorities[i] < priorities[j]) {
                    printed = false;
                    break;
                }
            }
            if (printed) {
                idxPrinted.add(i);
            } else {
                idxWaiting.offer(i);
            }
        }

        while (!idxWaiting.isEmpty()) {
            idxPrinted.add(idxWaiting.poll());
        }

        return idxPrinted.indexOf(location) + 1;

    }
}

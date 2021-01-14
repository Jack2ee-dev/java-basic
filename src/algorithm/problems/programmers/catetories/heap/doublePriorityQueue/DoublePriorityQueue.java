package algorithm.problems.programmers.catetories.heap.doublePriorityQueue;

import java.util.Arrays;
import java.util.LinkedList;

public class DoublePriorityQueue {
    
    public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(operations)));
    }
    
}

class Solution {
    
    public int[] solution(String[] operations) {
        LinkedList<Integer> qu = new LinkedList<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);
            if (command.equals("I")) {
                qu.offer(number);
                qu.sort(Integer::compareTo);
            } else {
                if (!qu.isEmpty()) {
                    if (number == -1) {
                        qu.sort(Integer::compareTo);
                        qu.pollFirst();
                    } else {
                        qu.sort((o1, o2) -> -o1.compareTo(o2));
                        qu.pollFirst();
                    }
                }
            }
        }
        
        qu.sort(Integer::compareTo);
        
        int[] answer = new int[2];
        if (!qu.isEmpty()) {
            if (qu.size() == 1) {
                answer[0] = answer[1] = qu.pollFirst();
            } else {
                answer[0] = qu.pollLast();
                answer[1] = qu.pollFirst();
            }
        }
        
        return answer;
    }
}
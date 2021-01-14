package algorithm.problems.programmers.catetories.heap.diskController;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
    
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        Solution s = new Solution();
        System.out.println(s.solution(jobs));
    }
    
}

class Solution {
    
    public int solution(int[][] jobs) {
        LinkedList<Work> waitings = new LinkedList<>();
        PriorityQueue<Work> works = new PriorityQueue<>();
        
        for (int[] job : jobs) {
            waitings.offer(new Work(job[0], job[1]));
        }
    
        waitings.sort(Comparator.comparingInt(o -> o.requestTime));
    
        int answer = 0;
        int cnt = 0;
        int time = waitings.peek().workTime;
        
        while (cnt < jobs.length) {
            while (!waitings.isEmpty() && waitings.peek().requestTime <= time) {
                works.offer(waitings.pollFirst());
            }
            
            if (!works.isEmpty()) {
                Work work = works.poll();
                cnt++;
                time += work.workTime;
                answer += time - work.requestTime;
            } else {
                time++;
            }
        }
        
        
        return answer / cnt;
    }
}

class Work implements Comparable<Work> {
    int requestTime;
    int workTime;
    
    public Work(int requestTime, int workTime) {
        this.requestTime = requestTime;
        this.workTime = workTime;
    }
    
    @Override
    public int compareTo(Work o) {
        return this.workTime - o.workTime;
    }
}
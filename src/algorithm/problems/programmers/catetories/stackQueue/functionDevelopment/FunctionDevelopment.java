package algorithm.problems.programmers.catetories.stackQueue.functionDevelopment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(progresses, speeds)));
    }

}

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length;
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            qu.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        List<Integer> temp = new ArrayList<>();
        while (!qu.isEmpty()) {
            int compared = qu.poll();
            int cnt = 1;
            for (int rest : qu) {
                if (compared < rest) {
                    break;
                }
                cnt++;
            }
            temp.add(cnt);
            for (int i = 0; i < cnt - 1; i++) {
                qu.poll();
            }
        }

        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }
}

package algorithm.problems.programmers.problems.level1.simulationTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationTest {

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(answers)));
    }
}

class Solution {

    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] ansP = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (p1[i % p1.length] == answers[i]) {
                ansP[0]++;
            }
            if (p2[i % p2.length] == answers[i]) {
                ansP[1]++;
            }
            if (p3[i % p3.length] == answers[i]) {
                ansP[2]++;
            }
        }

        int max = Math.max(Math.max(ansP[0], ansP[1]), Math.max(ansP[1], ansP[2]));
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < ansP.length; i++) {
            if (ansP[i] >= max) {
                temp.add(i + 1);
            }
        }
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
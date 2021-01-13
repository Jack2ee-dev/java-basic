package algorithm.problems.programmers.problems.level1.deleteMinNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteMinNumbers {

    public static void main(String[] args) {
        int[] arr = {10, 10};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(arr)));
    }
}


class Solution {

    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(-1);
        if (min < -1) {
            return new int[]{-1};
        }

        List<Integer> l = new ArrayList<>();
        for (int value : arr) {
            if (value > min) {
                l.add(value);
            }
        }
        int[] answer = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            answer[i] = l.get(i);
        }

        if (answer.length <= 1) {
            return new int[]{-1};
        }

        return answer;

    }
}
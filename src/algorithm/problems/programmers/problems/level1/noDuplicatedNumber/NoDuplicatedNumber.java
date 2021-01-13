package algorithm.problems.programmers.problems.level1.noDuplicatedNumber;

import java.util.Arrays;
import java.util.Stack;

public class NoDuplicatedNumber {

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 3, 3};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(arr)));
    }
}

class Solution {

    public int[] solution(int[] arr) {
        Stack<Integer> set = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.isEmpty()) {
                set.add(arr[i]);
            } else {
                if (set.peek() != arr[i]) {
                    set.add(arr[i]);
                }
            }
        }

        int[] answer = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            answer[i] = set.get(i);
        }

        return answer;
    }
}

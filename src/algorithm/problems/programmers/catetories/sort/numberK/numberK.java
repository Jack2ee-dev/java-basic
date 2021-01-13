package algorithm.problems.programmers.catetories.sort.numberK;

import java.util.Arrays;

public class numberK {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(array, commands)));
    }
}

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int commandLength = commands.length;
        int[] answer = new int[commandLength];
        for (int i = 0; i < commandLength; i++) {
            int[] subarray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(subarray);
            answer[i] = subarray[commands[i][2] - 1];
        }
        return answer;
    }
}
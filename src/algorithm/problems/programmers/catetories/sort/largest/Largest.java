package algorithm.problems.programmers.catetories.sort.largest;

import java.util.Arrays;

public class Largest {

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }
}

class Solution {

    public String solution(int[] numbers) {
        int length = numbers.length;
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            result[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (result[0].equals("0")) {
            return "0";
        }

        String answer = "";
        for (String s : result) {
            answer += s;
        }

        return answer;
    }
}
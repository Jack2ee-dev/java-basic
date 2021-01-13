package algorithm.problems.programmers.problems.level2.searchPrimary;

import java.util.HashSet;
import java.util.Set;

public class SearchPrimary {

    public static void main(String[] args) {
        String numbers = "17";
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }
}

class Solution {

    private static final boolean[] VISITED = new boolean[7];
    private static final Set<Integer> INTEGERS = new HashSet<>();
    private static final StringBuilder TEMP_STRING = new StringBuilder();

    public int solution(String numbers) {
        int answer = 0;
        String[] sp = numbers.split("");

        makeInteger(0, sp.length, sp);
        for (int integer : INTEGERS) {
            if (isPrimary(integer)) {
                answer++;
            }
        }

        return answer;
    }


    static void makeInteger(int depth, int limit, String[] numbers) {
        if (depth == limit) {
            return;
        }

        for (int i = 0; i < limit; i++) {
            if (!VISITED[i]) {
                VISITED[i] = true;
                TEMP_STRING.append(numbers[i]);
                INTEGERS.add(Integer.parseInt(TEMP_STRING.toString()));
                makeInteger(depth + 1, limit, numbers);
                TEMP_STRING.deleteCharAt(TEMP_STRING.length() - 1);
                VISITED[i] = false;
            }
        }
    }

    static boolean isPrimary(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        int uplimit = (int) Math.sqrt(number);
        for (int i = 2; i < uplimit; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

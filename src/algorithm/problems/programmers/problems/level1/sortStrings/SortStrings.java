package algorithm.problems.programmers.problems.level1.sortStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStrings {

    public static void main(String[] args) {
        String s = "Zbcdefg";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        List<String> lowerStrings = new ArrayList<>();
        List<String> upperStrings = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).toUpperCase().equals(s)) {
                upperStrings.add(s.substring(i, i + 1));
            } else {
                lowerStrings.add(s.substring(i, i + 1));
            }
        }

        Collections.sort(lowerStrings, Collections.reverseOrder());
        Collections.sort(upperStrings, Collections.reverseOrder());

        lowerStrings.addAll(upperStrings);

        for (String string : lowerStrings) {
            answer.append(string);
        }

        return answer.toString();
    }
}

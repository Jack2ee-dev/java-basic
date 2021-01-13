package algorithm.problems.programmers.problems.level1.notCompleted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotCompleted {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        Solution s = new Solution();
        System.out.println(s.solution(participant, completion));
    }
}

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> list = new ArrayList<>(Arrays.asList(participant));

        for (String completed : completion) {
            list.remove(completed);
        }

        answer = list.get(0);
        return answer;
    }
}

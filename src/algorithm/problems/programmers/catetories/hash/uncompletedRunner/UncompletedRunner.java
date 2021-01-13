package algorithm.problems.programmers.catetories.hash.uncompletedRunner;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class UncompletedRunner {

    public static void main(String[] args) {
        String[] participant = {
            "leo", "kiki", "eden"
        };
        String[] completion = {
            "eden", "kiki"
        };
        Solution s = new Solution();
        System.out.println(s.solution(participant, completion));
    }

}

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participants = new TreeMap<>();
        for (String part : participant) {
            participants.merge(part, 1, Integer::sum);
        }

        for (String complete : completion) {
            participants.put(complete, participants.get(complete) - 1);
        }

        for (Entry<String, Integer> part : participants.entrySet()) {
            if (part.getValue() != 0) {
                answer = part.getKey();
            }
        }

        return answer;
    }
}
package algorithm.problems.programmers.problems.level2.openChat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OpenChat {

    public static void main(String[] args) {
        String[] record = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(record)));
    }
}

class Solution {

    public String[] solution(String[] records) {
        Map<String, String> map = new HashMap<>();
        List<String> logs = new ArrayList<>();
        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String uid = split[1];
            if (command.equals("Leave")) {
                continue;
            }
            map.put(uid, split[2]);
        }

        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String uid = split[1];
            if (command.equals("Enter")) {
                logs.add(map.get(uid) + "님이 들어왔습니다.");
            }
            if (command.equals("Leave")) {
                logs.add(map.get(uid) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[logs.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = logs.get(i);
        }

        return answer;
    }

}
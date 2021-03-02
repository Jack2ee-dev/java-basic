package algorithm.problems.programmers.problems.level2.menuRenewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {

    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(orders, course)));
    }
}

class Solution {

    private static Map<String, Integer> map = new HashMap<>();
    private static boolean[] visit;
    private static final List<String> answerList = new ArrayList<>();

    public String[] solution(String[] orders, int[] courses) {
        for (int course : courses) {
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                visit = new boolean[chars.length];
                dfs(chars, course, 0, 0);
            }
            appendAnswer();
            map = new HashMap<>();
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    private void appendAnswer() {
        int mostFrequent = Integer.MIN_VALUE;
        for (int freq : map.values()) {
            if (freq > mostFrequent) {
                mostFrequent = freq;
            }
        }

        if (mostFrequent >= 2) {
            for (String key : map.keySet()) {
                if (map.get(key) == mostFrequent) {
                    answerList.add(key);
                }
            }
        }
    }

    private static void dfs(char[] chars, int depth, int currentDepth, int startIdx) {
        if (depth == currentDepth) {
            StringBuilder menu = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    menu.append(chars[i]);
                }
            }
            String strMenu = menu.toString();
            if (map.containsKey(strMenu)) {
                map.put(strMenu, map.get(strMenu) + 1);
            } else {
                map.put(strMenu, 1);
            }
            return;
        }

        for (int i = startIdx; i < chars.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(chars, depth, currentDepth + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
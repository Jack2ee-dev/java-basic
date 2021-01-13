package algorithm.problems.programmers.catetories.hash.camouflage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Camouflage {

    public static void main(String[] args) {
        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };
        Solution s = new Solution();
        System.out.println(s.solution(clothes));
    }
}

class Solution {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> categorized = new HashMap<>();
        for (String[] cloth : clothes) {
            categorized.merge(cloth[1], 1, (a, b) -> categorized.get(cloth[b]) + b);
        }

        Set<String> keys = categorized.keySet();
        for (String key : keys) {
            answer *= (categorized.get(key) + 1);
        }

        return answer - 1;
    }
}

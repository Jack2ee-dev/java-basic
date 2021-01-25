package algorithm.problems.programmers.problems.level2.tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

public class Tuple {

    public static void main(String[] args) {
        String s = "{{123}}";
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(s)));
    }
}

class Solution {

    public int[] solution(String s) {
        s = s.replaceAll("[{]", "")
            .replaceAll("},", " ")
            .replaceAll("}}", "");
        String[] split = s.split(" ");
        List<int[]> l = new ArrayList<>();
        for (String value : split) {
            String[] str = value.split(",");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            l.add(a);
        }

        l.sort(Comparator.comparingInt(a -> a.length));

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).length; j++) {
                set.add(l.get(i)[j]);
            }
        }


        int[] answer = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            answer[idx++] = num;
        }
        return answer;
    }
}
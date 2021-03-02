package algorithm.problems.baekjoon.string.timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_9251 {

    private static final List<String> strList1 = new ArrayList<>();
    private static final List<String> strList2 = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string1 = in.nextLine();
        String string2 = in.nextLine();
        boolean[] visit1 = new boolean[string1.length()];
        boolean[] visit2 = new boolean[string2.length()];
        for (int i = 1; i <= string1.length(); i++) {
            dfs(string1, strList1, 0, visit1, i, 0);
        }
        for (int i = 1; i < string2.length(); i++) {
            dfs(string2, strList2, 0, visit2, i, 0);
        }

        int max = Integer.MIN_VALUE;
        for (String str : strList1) {
            for (String str2 : strList2) {
                if (str.equals(str2)) {
                    max = Math.max(max, str.length());
                }
            }
        }
        System.out.println(max);
    }

    private static void dfs(String string, List<String> strList, int startIdx, boolean[] visit,
        int depth, int currentDepth) {
        if (depth == currentDepth) {
            StringBuilder appended = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    appended.append(string.charAt(i));
                }
            }
            strList.add(appended.toString());
        }

        for (int i = startIdx; i < string.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(string, strList, i + 1, visit, depth, currentDepth + 1);
                visit[i] = false;
            }
        }
    }
}

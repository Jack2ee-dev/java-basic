package algorithm.problems.programmers.catetories.dynamicProgramming.requiredRepetition.nExpression;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        Solution s = new Solution();
        System.out.println(s.solution(5, 12));
    }
}

class Solution {

    int _N;
    TreeSet<Integer>[] dp;

    public int solution(int N, int number) {
        _N = N;
        dp = new TreeSet[10];
        for (int i = 1; i <= 8; i++) {
            solve(i);
            if (dp[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    TreeSet<Integer> solve(int n) {
        if (dp[n] != null && !dp[n].isEmpty()) {
            return dp[n];
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            num = 10 * num + _N; // NNNNN 만들기
        }
        TreeSet<Integer> temp = new TreeSet<>();
        temp.add(num);

        for (int i = 1; i < n; i++) {
            int j = n - i;
            TreeSet<Integer> from = solve(i);
            TreeSet<Integer> to = solve(j);
            for (int n1 : from) {
                for (int n2 : to) {
                    temp.add(n1 + n2);
                    temp.add(n1 - n2);
                    temp.add(n1 * n2);
                    if (n2 != 0) {
                        temp.add(n1 / n2);
                    }
                }
            }
        }

        return dp[n] = temp;
    }
}
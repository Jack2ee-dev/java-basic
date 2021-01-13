package algorithm.problems.programmers.problems.level1.year2016;

public class Year2016 {

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        Solution s = new Solution();
        System.out.println(s.solution(a, b));
    }
}

class Solution {

    public String solution(int a, int b) {
        int total = 0;
        String w[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int m[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < a - 1; i++) {
            total += m[i];
        }
        total += b - 1;
        String answer = w[total % 7];
        return answer;
    }
}

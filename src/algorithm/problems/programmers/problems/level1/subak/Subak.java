package algorithm.problems.programmers.problems.level1.subak;

public class Subak {

    public static void main(String[] args) {
        int n = 4;
        Solution s = new Solution();
        System.out.println(Integer.parseInt("+123"));
        System.out.println(s.solution(n));
    }
}

class Solution {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String su = "수";
        String subak = "수박";
        boolean isEven = n % 2 == 0;

        if (isEven) {
            for (int i = 0; i < n / 2; i++) {
                answer.append(subak);
            }
        } else {
            for (int i = 0; i <= n / 2 - 1; i++) {
                answer.append(subak);
            }
            answer.append(su);
        }

        return answer.toString();
    }
}

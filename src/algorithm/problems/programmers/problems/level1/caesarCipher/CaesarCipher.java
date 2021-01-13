package algorithm.problems.programmers.problems.level1.caesarCipher;

public class CaesarCipher {

    public static void main(String[] args) {
        String s = "Z ";
        int n = 1;
        Solution solution = new Solution();
        System.out.println(solution.solution(s, n));
    }
}

class Solution {

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);

            if (alpha >= 'a' && alpha <= 'z') {
                if (alpha + n > 'z') {
                    answer.append((char) (alpha - 26 + n));
                } else {
                    answer.append((char) (alpha + n));
                }
            } else if (alpha >= 'A' && alpha <= 'Z') {
                if (alpha + n > 'Z') {
                    answer.append((char) (alpha - 26 + n));
                } else {
                    answer.append((char) (alpha + n));
                }
            } else {
                answer.append((char) alpha);
            }
        }
        return answer.toString();
    }
}
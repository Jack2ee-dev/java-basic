package algorithm.problems.programmers.problems.level2.compressString;

public class CompressString {

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }
}

class Solution {

    public int solution(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int compLen = compression(s, i).length();
            min = Math.min(min, compLen);
        }

        return min;
    }

    public String compression(String s, int unitCnt) {
        int count = 1;
        String compressed = "";
        String pattern = "";

        for (int j = 0; j < s.length() + unitCnt; j += unitCnt) {
            String nowStr;

            if (j >= s.length()) {
                nowStr = "";
            } else if (s.length() < j + unitCnt) {
                nowStr = s.substring(j);
            } else {
                nowStr = s.substring(j, j + unitCnt);
            }

            if (j != 0) {
                if (nowStr.equals(pattern)) {
                    count++;
                } else if (count >= 2) {
                    compressed += count + pattern;
                    count = 1;
                } else {
                    compressed += pattern;
                }
            }
            pattern = nowStr;
        }
        return compressed;
    }
}
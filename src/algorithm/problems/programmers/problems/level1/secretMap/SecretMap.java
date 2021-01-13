package algorithm.problems.programmers.problems.level1.secretMap;

import java.util.Arrays;

public class SecretMap {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n, arr1, arr2)));

    }
}

class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] binaried1 = new String[n][n];
        String[][] binaried2 = new String[n][n];

        for (int i = 0; i < n; i++) {
            StringBuilder binary1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder binary2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
            int length1 = binary1.length();
            int length2 = binary2.length();
            while (length1 < n) {
                binary1.insert(0, "0");
                length1++;
            }
            binaried1[i] = binary1.toString().split("");
            while (length2 < n) {
                binary2.insert(0, "0");
                length2++;
            }
            binaried2[i] = binary2.toString().split("");
        }

        for (int i = 0; i < n; i++) {
            StringBuilder mixed = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binaried1[i][j].equals("0") && binaried2[i][j].equals("0")) {
                    mixed.append(" ");
                } else {
                    mixed.append("#");
                }
            }
            answer[i] = mixed.toString();
        }

        return answer;
    }
}

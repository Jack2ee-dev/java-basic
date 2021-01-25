package algorithm.problems.naver.no2;

import java.util.Arrays;

public class No2 {

    public static void main(String[] args) {
        int N = -999;
        Solution s = new Solution();
        System.out.println(s.solution(N));
    }
}

class Solution {

    public int solution(int N) {
        boolean isNegative = N < 0;
        String[] str = Integer.toString(Math.abs(N)).split("");

        int index = 0;
        if (!isNegative) {
            for (int i = 0; i < str.length; i++) {
                if (Integer.parseInt(str[i]) < 5) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < str.length; i++) {
                if (Integer.parseInt(str[i]) > 5) {
                    index = i;
                    break;
                }
            }
        }

        String string = "";
        if (index == 0) {
            string += "5" + String.join("", str);
        } else {
            string += String.join("", str).substring(0, index) + "5" + String.join("", str).substring(index);
        }

        if (isNegative) {
            return Integer.parseInt(string) * -1;
        } else {
            return Integer.parseInt(string);
        }
    }
}
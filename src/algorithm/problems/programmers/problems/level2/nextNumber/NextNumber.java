package algorithm.problems.programmers.problems.level2.nextNumber;

import java.util.Arrays;

public class NextNumber {

    public static void main(String[] args) {
        int n = 1;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    public int solution(int n) {
        String[] binary = Integer.toBinaryString(n).split("");

        boolean allOne = true;
        for (String s : binary) {
            if (s.equals("0")) {
                allOne = false;
            }
        }

        if (allOne) {
            String zeroAppended = Integer.toBinaryString(n) + "0";
            binary = zeroAppended.split("");
        }

        int changeIdx = 0;
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i].equals("1")) {
                for (int j = i - 1; j >= 0; j--) {
                    if (binary[j].equals("0")) {
                        changeIdx = j;
                        break;
                    }
                }
                String temp = binary[i];
                binary[i] = binary[changeIdx];
                binary[changeIdx] = temp;
                break;
            }
        }

        String[] temp = new String[binary.length - changeIdx - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = binary[changeIdx + i + 1];
        }
        Arrays.sort(temp);

        for (int i = 0; i < temp.length; i++) {
            binary[changeIdx + i + 1] = temp[i];
        }

        return Integer.parseInt(String.join("", binary), 2);
    }
}

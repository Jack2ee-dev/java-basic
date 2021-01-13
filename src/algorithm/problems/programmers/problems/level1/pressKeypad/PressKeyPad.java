package algorithm.problems.programmers.problems.level1.pressKeypad;

public class PressKeyPad {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution s = new Solution();
        System.out.println(s.solution(numbers, hand));
    }
}

class Solution {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int rPoint = 12;
        int lPoint = 10;

        for (int num : numbers) {
            if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rPoint = num;
            } else if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                lPoint = num;
            } else {
                int rDistance;
                int lDistance;
                if (num == 0) {
                    rDistance = Math.abs(11 - rPoint) / 3 + Math.abs(11 - rPoint) % 3;
                    lDistance = Math.abs(11 - lPoint) / 3 + Math.abs(11 - lPoint) % 3;
                    num = 11;
                } else {
                    rDistance = Math.abs(num - rPoint) / 3 + Math.abs(num - rPoint) % 3;
                    lDistance = Math.abs(num - lPoint) / 3 + Math.abs(num - lPoint) % 3;
                }

                if (rDistance < lDistance) {
                    answer.append("R");
                    rPoint = num;
                } else if (lDistance < rDistance) {
                    answer.append("L");
                    lPoint = num;
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        rPoint = num;
                    } else {
                        answer.append("L");
                        lPoint = num;
                    }
                }
            }


        }

        return answer.toString();
    }
}

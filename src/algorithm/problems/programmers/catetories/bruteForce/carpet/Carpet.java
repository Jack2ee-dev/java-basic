package algorithm.problems.programmers.catetories.bruteForce.carpet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(brown, yellow)));
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<MiddleRec> middleRecs = new ArrayList<>();
        int divideLimit = (int) Math.sqrt(yellow);
        for (int i = 1; i <= divideLimit; i++) {
            if (yellow % i == 0) {
                middleRecs.add(new MiddleRec(i, yellow/i));
            }
        }

        for (MiddleRec mr : middleRecs) {
            if (mr.contBrown() == brown) {
                answer[0] = mr.width + 2;
                answer[1] = mr.height + 2;
            }
        }
        return answer;
    }
}

class MiddleRec {
    int height;
    int width;

    public MiddleRec(int height, int width) {
        this.height = height;
        this.width = width;
    }

    int contBrown() {
        return 4 + height *2 +width*2;
    }
}
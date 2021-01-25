package algorithm.problems.programmers.problems.level2.completeRect;

public class CompleteRect {

    public static void main(String[] args) {
        int w = 2;
        int h = 2;
        Solution s = new Solution();
        System.out.println(s.solution(w, h));
    }
}

class Solution {

    public long solution(int w, int h) {
        long answer = 1;

        int div = 0;
        int smallW = w;
        int smallH = h;
        if (w == h) {
            return (long) w * h - w;
        }


        while ((double) smallW / 2 == Math.floor((double) smallW / 2) && (double) smallH / 2 == (int) Math
            .floor((double) smallH / 2)) {
            smallW /= 2;
            smallH /= 2;
            div++;
        }


        return answer;
    }
}
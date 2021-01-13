package algorithm.problems.programmers.problems.level2.completeRect;

public class CompleteRect {

    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        Solution s = new Solution();
        System.out.println(s.solution(w, h));
    }
}

class Solution {

    public long solution(int w, int h) {
        long answer = 1;
        boolean isEvenW = w % 2 == 0;
        boolean isEvenH = h % 2 == 0;

        if (w == h) {
            answer = (long) w * (w - 1);
        } else {
            if (isEvenW && isEvenH) {
                answer = (long) w * h / 2;
            }
            if (isEvenW && !isEvenH) {
                answer = (long) h / 2 * w;
            }
            if (!isEvenW && isEvenH) {
                answer = (long) w / 2 * h;
            }
            if (!isEvenW && !isEvenH) {
                if (w > h) {
                    answer = (long) (w - 2) * (h - 1);
                } else {
                    answer = (long) (h - 2) * (w - 1);
                }
            }
        }

        return answer;
    }
}
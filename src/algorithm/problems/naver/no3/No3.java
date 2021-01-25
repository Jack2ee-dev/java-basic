package algorithm.problems.naver.no3;

public class No3 {

    public static void main(String[] args) {
        String s = "Thu";
        int K = 2;
        Solution solution = new Solution();
        System.out.println(solution.solution(s, K));
    }
}

class Solution {
    public String solution(String S, int K) {
        String[] days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int index = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(S)) {
                index = i;
                break;
            }
        }

        if (index + K % days.length >= days.length) {
            index = K % days.length - (days.length - index);
        } else {
            index += K % days.length;
        }

        return days[index];
    }
}
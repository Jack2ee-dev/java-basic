package algorithm.problems.programmers.problems.skillCheck2.no1;

import java.util.HashSet;
import java.util.Set;

public class No1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution s = new Solution();
        System.out.println(s.solution(nums));
    }
}

class Solution {

    private static int[] arr;
    private static boolean[] visit;
    private int answer = 0;
    private static Set<Integer> set = new HashSet<>();

    public int solution(int[] nums) {
        arr = nums;
        visit = new boolean[nums.length];

        dfs(0, 0);

        for (int num : set) {
            int sqrt = (int) Math.sqrt(num);
            boolean isPrime = true;
            for (int j = 2; j <= sqrt; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int depth, int num) {
        if (depth == 3) {
            set.add(num);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, num + arr[i]);
                visit[i] = false;
            }
        }
    }
}
package algorithm.problems.programmers.problems.level2.searchPrimary;

import java.util.HashSet;
import java.util.Set;

public class SearchPrimary {

    public static void main(String[] args) {
        String numbers = "011";
        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }
}

class Solution {

    private static int[] nums;
    private static boolean[] visit;
    private static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        String[] split = numbers.split("");
        visit = new boolean[split.length];
        nums = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        for (int i = 1; i <= split.length; i++) {
            dfs(0, i, "");
        }

        for (int num : set) {
            if (num != 0 && num != 1) {
                if (num == 2) {
                    answer++;
                } else {
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
            }
        }

        return answer;
    }

    private void dfs(int depth, int limit, String num) {
        if (depth == limit) {
            set.add(Integer.parseInt(num));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, limit, num + nums[i]);
                visit[i] = false;
            }
        }
    }

}

package algorithm.problems.programmers.problems.level2.phoneketMon;

import java.util.HashSet;
import java.util.Set;

public class PhoneKetMon {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.solution(nums));
    }
}
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        return Math.min(nums.length / 2, set.size());
    }
}
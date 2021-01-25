package algorithm.problems.programmers.problems.level2.gcd;

import java.util.LinkedList;

public class GCD {

    public static void main(String[] args) {
        int[] arr = {
            1, 2, 3
        };
        Solution s = new Solution();
        System.out.println(s.solution(arr));
    }
}

class Solution {

    private int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return gcd(num2, num1 % num2);
        }
    }

    public int solution(int[] arr) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int n : arr) {
            list.add(n);
        }

        while (list.size() > 1) {
            int num1 = list.pollFirst();
            int num2 = list.pollFirst();
            list.push(num1 * num2 / gcd(num1, num2));
        }

        answer = list.pollFirst();

        return answer;
    }
}
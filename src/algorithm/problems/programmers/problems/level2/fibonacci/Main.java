package algorithm.problems.programmers.problems.level2.fibonacci;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n) {
        return fiboTail(n, 0, 1);
    }

    private int fiboTail(int n, int before, int next) {
        if (n == 0) {
            return before % 1234567;
        }
        return fiboTail(n - 1, next % 1234567, (before + next) % 1234567);
    }
}
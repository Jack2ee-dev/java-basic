package algorithm.problems.programmers.problems.level1.primeNumber;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public static void main(String[] args) {
        int n = 10;
        Solution s = new Solution();
        System.out.println(s.solution(n));
    }
}

class Solution {

    public int solution(int n) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        if (n == 2) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (Integer p : primes) {
                if (i % p == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primes.add(i);
            }
        }

        return primes.size();
    }
}





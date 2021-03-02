package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem_9461 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int trial = in.nextInt();
        for (int i = 0; i < trial; i++) {
            List<Integer> base = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2));
            int N = in.nextInt();
            if (N < base.size()) {
                System.out.println(base.get(N - 1));
            }

            while (base.size() < N) {
                base.add(base.get(N - 2) + base.get(N - 1));
                System.out.println(base.get(base.size() - 1));
            }
        }
    }
}

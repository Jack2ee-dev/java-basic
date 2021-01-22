package algorithm.problems.baekjoon.queue.unsolved;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_1021 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] NM = in.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Queue<Integer> qu = new LinkedList<>();
        String[] location_input = in.nextLine().split(" ");
        for (int i = 0; i < location_input.length; i++) {
            qu.offer(Integer.parseInt(location_input[i]) - 1);
        }

        int answer = 0;
        int cur = 0;
        while (!qu.isEmpty()) {
            int peek = qu.poll();
            int d1 = Math.abs(peek - cur);
            int d2 = Math.abs(N - cur + peek);
            cur = peek;
            answer += Math.min(d1, d2);
        }

        System.out.println(answer);

    }
}

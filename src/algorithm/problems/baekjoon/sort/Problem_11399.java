package algorithm.problems.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> times = new ArrayList<>(N);
        String inputTime = bf.readLine();
        StringTokenizer st = new StringTokenizer(inputTime, " ");
        while (st.hasMoreTokens()) {
            times.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(times);
        int total = 0;
        for (int i = 0; i < N; i++) {
            int fractionSum = 0;
            for (int j = 0; j <= i; j++) {
                fractionSum += times.get(j);
            }
            total += fractionSum;
        }
        System.out.println(total);
    }
}

package algorithm.problems.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Integer> numbers = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(numbers);
        StringBuilder st = new StringBuilder();
        for (int number : numbers) {
            st.append(number).append("\n");
        }
        System.out.println(st);
    }
}

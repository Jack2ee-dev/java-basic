package algorithm.problems.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputNumbers = bf.readLine();
        String[] split = inputNumbers.split("");
        List<Integer> numbers = new ArrayList<>();
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }

        numbers.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        System.out.println(sb);
    }
}

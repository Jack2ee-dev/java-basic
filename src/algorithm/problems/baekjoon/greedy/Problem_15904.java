package algorithm.problems.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_15904 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("[a-z\b]");
        System.out.println(Arrays.toString(input));

        StringBuilder compared = new StringBuilder();
        for (String str : input) {
            if (!str.equals("") && !str.equals(" ")) {
                System.out.println(str);
                compared.append(str);
            }
        }

        if (compared.toString().equals("UCPC")) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}

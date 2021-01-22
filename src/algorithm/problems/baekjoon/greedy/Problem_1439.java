package algorithm.problems.baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Problem_1439 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] onlyZero = input.split("[1+]");
        String[] onlyOne = input.split("[0+]");

        int one = 0;
        int zero = 0;

        for (String s : onlyZero) {
            if (!s.equals("")) {
                zero++;
            }
        }

        for (String s : onlyOne) {
            if (!s.equals("")) {
                one++;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}

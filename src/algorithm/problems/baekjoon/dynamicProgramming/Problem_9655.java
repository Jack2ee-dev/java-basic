package algorithm.problems.baekjoon.dynamicProgramming;

import java.util.Scanner;

public class Problem_9655 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        // sk -> cy
        if (N % 4 == 1 || N % 4 == 3) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}

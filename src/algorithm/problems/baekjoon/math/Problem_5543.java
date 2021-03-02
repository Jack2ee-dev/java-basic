package algorithm.problems.baekjoon.math;

import java.util.Scanner;

public class Problem_5543 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] burgers = new int[3];
        int[] beverages = new int[2];
        for (int i = 0; i < burgers.length; i++) {
            burgers[i] = in.nextInt();
        }
        for (int i = 0; i < beverages.length; i++) {
            beverages[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int burger : burgers) {
            for (int beverage : beverages) {
                int set = burger + beverage - 50;
                min = Math.min(min, set);
            }
        }
        System.out.println(min);
    }
}

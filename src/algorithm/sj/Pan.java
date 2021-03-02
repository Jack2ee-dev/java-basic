package algorithm.sj;

import java.util.Scanner;

public class Pan {

    private static int[] pan;
    private static boolean[] already;
    private static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NN = in.nextInt();
        pan = new int[NN];
        already = new boolean[NN];
        for (int i = 0; i < pan.length; i++) {
            pan[i] = in.nextInt();
        }
        step(NN);
        System.out.println(MAX);
    }

    private static void step(int NN) {
        int[] can = {0, 1, 2};
        for (int j : can) {
            int cur = j;
            int s = 1;
            already = new boolean[NN];
            while (!already[cur]) {
                already[cur] = true;
                cur += pan[cur];
                s++;
            }
            MAX = Math.max(MAX, s);
        }
    }
}

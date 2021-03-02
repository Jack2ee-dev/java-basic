package algorithm.sj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mole {

    private static int[][] moles;
    private static Map<Integer, Integer> ups = new HashMap();
    private static int MAX = Integer.MIN_VALUE;
    private static int durationMax = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int NN = in.nextInt();
        moles = new int[NN][NN];
        for (int i = 0; i < NN * NN; i++) {
            int score = in.nextInt();
            int cnt = in.nextInt();
            for (int j = 0; j < cnt; j++) {
                if (ups.containsKey(score)) {

                }
            }
        }
        game();
        System.out.println(MAX);
    }

    private static void game() {

    }
}

/*
2
1 3 1 3 5
2 2 2 4
3 2 1 2
4 1 3
 */
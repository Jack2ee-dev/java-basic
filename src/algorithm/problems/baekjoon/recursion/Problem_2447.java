package algorithm.problems.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2447 {

    private static char[][] painted;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        painted = new char[N][N];
        draw(N, 0, 0);
        print(sb);
    }

    private static void print(StringBuilder sb) {
        for (int i = 0; i < painted.length; i++) {
            for (int j = 0; j < painted[i].length; j++) {
                sb.append(painted[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void draw(int n, int x, int y) {
        if (n == 1) {
            painted[y][x] = '*';
            return;
        }

        draw(n / 3, x, y);
        draw(n / 3, x + n / 3, y);
        draw(n / 3, x + 2 * n / 3, y);

        draw(n / 3, x, y + n / 3);
        draw(n / 3, x + 2 * n / 3, y + n / 3);

        draw(n / 3, x, y + 2 * n / 3);
        draw(n / 3, x + n / 3, y + 2 * n / 3);
        draw(n / 3, x + 2 * n / 3, y + 2 * n / 3);
    }
}

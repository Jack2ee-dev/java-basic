package algorithm.problems.programmers.problems.level2.triangleSnail;

import java.util.Arrays;

public class TriangleSnail {

    public static void main(String[] args) {
        int n = 6;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(n)));
    }
}

class Solution {

    public int[] solution(int n) {
        int size = n * (n + 1) / 2;
        int[] answer = new int[size];

        int[][] map = new int[n][n];
        int direction = 0;
        int x = 0, y = 0;
        int cnt = n;
        int cur = 0;
        for (int i = 1; i <= size; i++) {
            if (direction == 0) {
                map[x][y] = i;
                if (cur == cnt - 1) {
                    direction = 1;
                    y++;
                    cur = 0;
                    cnt--;
                } else {
                    x++;
                    cur++;
                }
            } else if (direction == 1) {
                map[x][y] = i;
                if (cur == cnt - 1) {
                    direction = -1;
                    x--;
                    y--;
                    cnt--;
                    cur = 0;
                } else {
                    y++;
                    cur++;
                }
            } else {
                map[x][y] = i;
                if (cur == cnt - 1) {
                    direction = 0;
                    x++;
                    cnt--;
                    cur = 0;
                } else {
                    x--;
                    y--;
                    cur++;
                }
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}
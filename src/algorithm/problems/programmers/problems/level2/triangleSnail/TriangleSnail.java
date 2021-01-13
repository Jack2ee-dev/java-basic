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
        int[][] matrix = new int[n][n];
        int length = n * (n + 1) / 2;
        int[] answer = new int[length];

        String direction = "down";
        int number = 1;
        int x = 0;
        int y = 0;
        int rightBorder = n - 1;
        int upBorder = 1;
        int downBorder = n - 1;
        while (true) {
            if (direction.equals("down")) {
                if (x <= downBorder) {
                    matrix[x++][y] = number++;
                } else {
                    direction = "right";
                    downBorder--;
                    x--;
                    y++;
                }
            }
            if (number == length + 1) {
                break;
            }
            if (direction.equals("right")) {
                if (y <= rightBorder) {
                    matrix[x][y++] = number++;
                } else {
                    direction = "up";
                    rightBorder--;
                    y -= 2;
                    x--;
                }
            }
            if (number == length + 1) {
                break;
            }
            if (direction.equals("up")) {
                if (x >= upBorder) {
                    matrix[x--][y--] = number++;
                } else {
                    direction = "down";
                    upBorder++;
                    x += 2;
                    y++;
                }
            }
            if (number == length + 1) {
                break;
            }
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}